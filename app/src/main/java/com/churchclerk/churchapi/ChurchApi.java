/*

 */
package com.churchclerk.churchapi;

import com.churchclerk.baseapi.BaseApi;
import com.churchclerk.baseapi.model.ApiCaller;
import com.churchclerk.churchapi.model.Church;
import com.churchclerk.churchapi.service.ChurchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import javax.ws.rs.*;
import java.util.Date;
import java.util.UUID;

/**
 *
 */
@Component
@Path("/church")
public class ChurchApi extends BaseApi<Church> {

    private static Logger logger = LoggerFactory.getLogger(ChurchApi.class);

    @QueryParam("name")
    protected String nameLike;


    @Autowired
    private ChurchService service;

    /**
     *
     */
    public ChurchApi() {
        super(logger, Church.class);
        setReadRoles(ApiCaller.Role.ADMIN, ApiCaller.Role.CLERK, ApiCaller.Role.OFFICIAL, ApiCaller.Role.MEMBER, ApiCaller.Role.NONMEMBER);
        setUpdateRoles(ApiCaller.Role.ADMIN);
    }

    @Override
    protected Page<? extends Church> doGet(Pageable pageable) {

        return service.getResources(pageable, createCriteria());
    }

    /**
     *
     * @return
     */
    protected Church createCriteria() {
        Church criteria	= new Church();

        addBaseCriteria(criteria);

        criteria.setName(nameLike);

        if (id == null) {
            apiCaller.getMemberOf().forEach(churchId -> {
                if (id == null) {
                    id = churchId;
                }
            });
        }

        if (readAllowed(id, this::hasSuperRole)) {
            if (id != null) {
                criteria.setId(id);
            }
        }
        else {
            // force return of empty array
            criteria.setId("NOTALLOWED");
        }

        return criteria;
    }

    @Override
    protected Church doGet() {
        if ((id == null) || (id.trim().isEmpty())) {
            throw new BadRequestException("Church id cannot be empty");
        }

        Church resource = service.getResource(id);

        if ((resource == null) || (readAllowed(resource.getId()) == false)) {
            throw new NotFoundException();
        }

        return resource;
    }

    @Override
    protected Church doCreate(Church resource) {
        if (resource.getId() != null) {
            throw new BadRequestException("Church id should not be present");
        }

        if (resource.getName() == null) {
            throw new BadRequestException("Church's name cannot be null");
        }

        if (createAllowed(resource.getId(), this::hasSuperRole) == false) {
            throw new ForbiddenException();
        }

        resource.setId(UUID.randomUUID().toString());
        resource.setCreatedBy(apiCaller.getUserid());
        resource.setCreatedDate(new Date());
        resource.setUpdatedBy(apiCaller.getUserid());
        resource.setUpdatedDate(new Date());

        return service.createResource(resource);
    }

    @Override
    protected Church doUpdate(Church resource) {
        if ((id == null) || (id.isEmpty()) || (resource.getId() == null) || (resource.getId().isEmpty())) {
            throw new BadRequestException("Church id cannot be empty");
        }

        if (resource.getId().equals(id) == false) {
            throw new BadRequestException("Church id does not match");
        }

        if ((resource.getName() == null) || (resource.getName().trim().isEmpty())) {
            throw new BadRequestException("Church name cannot be empty");
        }

        if (updateAllowed(id) == false) {
            throw new ForbiddenException();
        }

        resource.setUpdatedBy(apiCaller.getUserid());
        resource.setUpdatedDate(new Date());

        return service.updateResource(resource);
    }

    @Override
    protected Church doDelete() {
        if ((id == null) || id.isEmpty()) {
            throw new BadRequestException("Church id cannot be empty");
        }

        if (deleteAllowed(id) == false) {
            throw new ForbiddenException();
        }

        return service.deleteResource(id);
    }
}
