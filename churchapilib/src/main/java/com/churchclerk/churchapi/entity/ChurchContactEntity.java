/**
 * 
 */
package com.churchclerk.churchapi.entity;

import com.churchclerk.contactapi.entity.ContactEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


/**
 * 
 * @author dongp
 *
 */
@Entity
@Table(name="church")
@Setter
@SuperBuilder
@NoArgsConstructor
public class ChurchContactEntity extends BaseChurchEntity {

	private ContactEntity contactEntity;


	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER, optional = true, cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "contact_id", nullable = true)
	public ContactEntity getContactEntity() {
		return contactEntity;
	}

}
