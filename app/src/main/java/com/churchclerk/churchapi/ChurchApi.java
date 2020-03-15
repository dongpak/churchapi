/*

 */
package com.churchclerk.churchapi;

import com.churchclerk.baseapi.BaseApi;
import com.churchclerk.churchapi.model.Church;
import com.churchclerk.churchapi.service.ChurchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import java.util.Date;

/**
 *
 */
@Component
@Path("/church")
public class ChurchApi extends BaseApi<Church> {

    private static Logger logger = LoggerFactory.getLogger(ChurchApi.class);

    @Autowired
    private ChurchService service;

    /**
     *
     */
    public ChurchApi() {
        super(logger, Church.class);
        setReadRoles(Role.ADMIN, Role.CLERK, Role.OFFICIAL, Role.MEMBER, Role.NONMEMBER);
        setUpdateRoles(Role.ADMIN);
        setDeleteRoles(Role.ADMIN);
    }

    /**
     *
     * @return
     */
    protected Church createCriteria() {
        Church criteria	= new Church();

        addBaseCriteria(criteria);

        return criteria;
    }

    @Override
    protected Page<? extends Church> doGet(Pageable pageable) {

        return service.getResources(pageable, createCriteria());
    }

    @Override
    protected Church doGet(String id) {

            Church resource = service.getResource(id);

            return resource;
    }

    @Override
    protected Church doCreate(Church resource) {

        resource.setCreatedBy(requesterId);
        resource.setCreatedDate(new Date());
        resource.setUpdatedBy(requesterId);
        resource.setUpdatedDate(new Date());
        return resource;
    }

    @Override
    protected Church doUpdate(Church resource) {
        Church found = service.getResource(id);

        resource.setUpdatedBy(requesterId);
        resource.setUpdatedDate(new Date());

        return service.updateResource(resource);
    }

    @Override
    protected Church doDelete(String id) {
        return service.deleteResource(id);
    }
}
