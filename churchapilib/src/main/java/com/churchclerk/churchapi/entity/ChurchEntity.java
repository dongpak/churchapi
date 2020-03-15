/**
 * 
 */
package com.churchclerk.churchapi.entity;

import com.churchclerk.churchapi.model.Church;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * 
 * @author dongp
 *
 */
@Entity
@Table(name="church")
public class ChurchEntity extends Church {

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
