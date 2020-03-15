/**
 * 
 */
package com.churchclerk.churchapi.service;

import com.churchclerk.churchapi.entity.ChurchEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;


/**
 * 
 * @author dongp
 *
 */
public interface ChurchStorage extends CrudRepository<ChurchEntity, String>, JpaSpecificationExecutor<ChurchEntity> {

}
