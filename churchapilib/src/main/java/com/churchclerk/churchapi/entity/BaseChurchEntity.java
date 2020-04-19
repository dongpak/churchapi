/**
 * 
 */
package com.churchclerk.churchapi.entity;

import com.churchclerk.churchapi.model.Church;
import com.churchclerk.contactapi.model.Contact;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.Date;


/**
 * 
 * @author dongp
 *
 */
@MappedSuperclass
public abstract class BaseChurchEntity extends Church {

	@Column(name="active")
	@Override
	public boolean isActive() {
		return super.isActive();
	}

	@Id
	@Column(name="id")
	@Override
	public String getId() {
		return super.getId();
	}

	@Column(name="name")
	@Override
	public String getName() {
		return super.getName();
	}

	@Transient
	@Override
	public Contact getContact() {
		return super.getContact();
	}

	@Override
	public Date getCreatedDate() {
		return super.getCreatedDate();
	}

	@Override
	public String getCreatedBy() {
		return super.getCreatedBy();
	}

	@Override
	public Date getUpdatedDate() {
		return super.getUpdatedDate();
	}

	@Override
	public String getUpdatedBy() {
		return super.getUpdatedBy();
	}
}
