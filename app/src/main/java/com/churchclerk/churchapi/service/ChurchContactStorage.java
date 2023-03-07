/**
 * 
 */
package com.churchclerk.churchapi.service;

import com.churchclerk.churchapi.entity.ChurchContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;


/**
 * 
 * @author dongp
 *
 */
public interface ChurchContactStorage extends JpaRepository<ChurchContactEntity, UUID>, JpaSpecificationExecutor<ChurchContactEntity> {

}
