/**
 * 
 */
package com.churchclerk.churchapi.entity;

import com.churchclerk.contactapi.entity.ContactEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


/**
 * 
 * @author dongp
 *
 */
@Entity
@Table(name="church")
public class ChurchContactEntity extends BaseChurchEntity {

	private ContactEntity contactEntity;


	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER, optional = true, cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "contact_id", nullable = true)
	public ContactEntity getContactEntity() {
		return contactEntity;
	}

	public void setContactEntity(ContactEntity contactEntity) {
		this.contactEntity = contactEntity;
	}

}
