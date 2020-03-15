/**
 * 
 */
package com.churchclerk.churchapi.service;

import com.churchclerk.churchapi.entity.ChurchEntity;
import com.churchclerk.churchapi.model.Church;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.Optional;


/**
 * 
 * @author dongp
 *
 */
@Service
public class ChurchService {

	private static Logger logger	= LoggerFactory.getLogger(ChurchService.class);

	@Autowired
	private ChurchStorage storage;


	/**
	 *
	 * @return
	 */
	public Page<? extends Church> getResources(Pageable pageable, Church criteria) {

		Page<ChurchEntity> page = storage.findAll(new ChurchResourceSpec(criteria), pageable);

		return page;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Church getResource(String id) {

		Optional<ChurchEntity> entity = storage.findById(id);

		checkResourceNotFound(id, entity);
		return entity.get();
	}

	private void checkResourceNotFound(String id, Optional<ChurchEntity> optional) {
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
		ChurchEntity entity = new ChurchEntity();

		entity.copy(resource);

		return storage.save(entity);
	}


	/**
	 *
	 * @param resource
	 * @return
	 */
	public Church updateResource(Church resource) {
		Optional<ChurchEntity> optional = storage.findById(resource.getId());

		checkResourceNotFound(resource.getId(), optional);

		ChurchEntity entity = optional.get();

		entity.copy(resource);
		return storage.save(entity);
	}



	/**
	 *
	 * @param id
	 * @return
	 */
	public Church deleteResource(String id) {
		Optional<ChurchEntity> optional = storage.findById(id);

		checkResourceNotFound(id, optional);

		storage.deleteById(id);
		return optional.get();
	}
}
