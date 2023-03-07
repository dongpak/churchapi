/**
 * 
 */
package com.churchclerk.churchapi.service;

import com.churchclerk.churchapi.entity.ChurchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;


/**
 * 
 * @author dongp
 *
 */
public interface ChurchStorage extends JpaRepository<ChurchEntity, UUID>, JpaSpecificationExecutor<ChurchEntity> {

}
