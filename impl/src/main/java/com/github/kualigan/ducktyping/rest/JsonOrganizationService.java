/**
 * Copyright 2005-2014 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl2.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.kualigan.ducktyping.rest;

import com.github.kualigan.ducktyping.api.Organization;
import com.github.kualigan.ducktyping.api.OrganizationService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Service implementation for looking up {@link Organization} over ReST or JAX-WS
 *
 * @author Leo Przybylski
 */
@Path("/Organizations")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class JsonOrganizationService {
    @Autowired
    private OrganizationService organizationService;

    
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganization(@PathParam("id") final String organizationId) {
        return Response.ok(getOrganizationService().getOrganization(organizationId)).build();
    }

    public void setOrganizationService(final OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    public OrganizationService getOrganizationService() {
        return this.organizationService;
    }
}
