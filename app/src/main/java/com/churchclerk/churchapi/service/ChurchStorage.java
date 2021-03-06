/**
 * 
 */
package com.churchclerk.churchapi.service;

import com.churchclerk.churchapi.entity.ChurchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * 
 * @author dongp
 *
 */
public interface ChurchStorage extends JpaRepository<ChurchEntity, String>, JpaSpecificationExecutor<ChurchEntity> {

}
