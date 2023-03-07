/**
 * 
 */
package com.churchclerk.churchapi.entity;

import com.churchclerk.churchapi.model.Church;
import com.churchclerk.contactapi.model.Contact;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


/**
 * 
 * @author dongp
 *
 */
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseChurchEntity extends Church {

	@Column(name="active")
	@Override
	public boolean isActive() {
		return super.isActive();
	}

	@Id
	@Column(name="id")
	@Override
	public UUID getId() {
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

	@Column(name="created_date")
	@Override
	public Date getCreatedDate() {
		return super.getCreatedDate();
	}

	@Column(name="created_by")
	@Override
	public String getCreatedBy() {
		return super.getCreatedBy();
	}

	@Column(name="updated_date")
	@Override
	public Date getUpdatedDate() {
		return super.getUpdatedDate();
	}

	@Column(name="updated_by")
	@Override
	public String getUpdatedBy() {
		return super.getUpdatedBy();
	}
}
