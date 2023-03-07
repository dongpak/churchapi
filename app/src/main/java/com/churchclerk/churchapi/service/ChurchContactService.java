/**
 * 
 */
package com.churchclerk.churchapi.service;

import com.churchclerk.churchapi.entity.ChurchContactEntity;
import com.churchclerk.churchapi.model.Church;
import com.churchclerk.contactapi.entity.ContactEntity;
import com.churchclerk.contactapi.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.Optional;
import java.util.UUID;


/**
 * 
 * @author dongp
 *
 */
@Service
public class ChurchContactService {

	private static Logger logger	= LoggerFactory.getLogger(ChurchContactService.class);

	@Autowired
	private ChurchContactStorage	storage;


	/**
	 *
	 * @return
	 */
	public Page<? extends Church> getResources(Pageable pageable, Church criteria) {

		Page<ChurchContactEntity> page = storage.findAll(new ChurchContactResourceSpec(criteria), pageable);

		if (page != null) {
			page.forEach(this::moveContact);
		}
		return page;
	}


	private void moveContact(ChurchContactEntity entity) {
		if (entity.getContactEntity() != null) {
			entity.setContact(entity.getContactEntity());
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Church getResource(String id) {

		Optional<ChurchContactEntity> optional = storage.findById(UUID.fromString(id));

		checkResourceNotFound(id, optional);

		ChurchContactEntity	entity = optional.get();

		moveContact(entity);
		return entity;
	}

	private void checkResourceNotFound(String id, Optional<ChurchContactEntity> optional) {
		if (optional.isPresent() == false) {
			throw new NotFoundException("No such Church resource with id: " + id);
		}
	}

	/**
	 *
	 * @param resource
	 * @return
	 */
	public Church createResource(Church resource) {
		ChurchContactEntity entity = new ChurchContactEntity();

		entity.copy(resource);
		if (resource.getContact() != null) {
			entity.setContactEntity(
					createContactEntity(resource.getContact())
			);
		}

		ChurchContactEntity saved = storage.save(entity);
		moveContact(saved);

		return saved;
	}

	private ContactEntity createContactEntity(Contact resource) {
		ContactEntity entity = new ContactEntity();

		entity.copy(resource);

		return entity;
	}

	/**
	 *
	 * @param resource
	 * @return
	 */
	public Church updateResource(Church resource) {
		Optional<ChurchContactEntity> optional = storage.findById(resource.getId());

		checkResourceNotFound(resource.getId().toString(), optional);

		ChurchContactEntity entity = optional.get();

		entity.copyNonNulls(resource);
		if (resource.getContact() != null) {
			if ((entity.getContactEntity() == null)
			||  (resource.getContact().getId().equals(entity.getContactEntity().getId()) == false)) {
				// recreate contact from resource
				entity.setContactEntity(
						createContactEntity(resource.getContact())
				);
			}
		}

		ChurchContactEntity saved = storage.save(entity);
		moveContact(saved);

		return saved;
	}



	/**
	 *
	 * @param id
	 * @return
	 */
	public Church deleteResource(String id) {
		Optional<ChurchContactEntity> optional = storage.findById(UUID.fromString(id));

		checkResourceNotFound(id, optional);

		storage.deleteById(UUID.fromString(id));

		ChurchContactEntity	entity = optional.get();
		moveContact(entity);

		return entity;
	}
}
