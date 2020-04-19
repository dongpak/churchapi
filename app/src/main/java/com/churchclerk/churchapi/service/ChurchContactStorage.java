/**
 * 
 */
package com.churchclerk.churchapi.service;

import com.churchclerk.churchapi.entity.ChurchContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * 
 * @author dongp
 *
 */
public interface ChurchContactStorage extends JpaRepository<ChurchContactEntity, String>, JpaSpecificationExecutor<ChurchContactEntity> {

}
