/**
 * 
 */
package com.churchclerk.churchapi.entity;

import com.churchclerk.churchapi.model.Church;
import com.churchclerk.contactapi.model.Contact;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * 
 * @author dongp
 *
 */
@Entity
@Table(name="church")
public class ChurchEntity extends BaseChurchEntity {

	private String contactId;

	@Column(name="contact_id")
	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

}
