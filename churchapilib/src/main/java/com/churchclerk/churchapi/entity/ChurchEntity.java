/**
 * 
 */
package com.churchclerk.churchapi.entity;

import com.churchclerk.churchapi.model.Church;
import com.churchclerk.contactapi.model.Contact;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.UUID;


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
public class ChurchEntity extends BaseChurchEntity {

	private UUID contactId;

	@Column(name="contact_id")
	public UUID getContactId() {
		return contactId;
	}
}
