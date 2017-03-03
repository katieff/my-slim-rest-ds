package de.msggillardon.coc.application;

import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import de.msggillardon.coc.pojos.MyEntity;
import de.msggillardon.coc.service.MyEntityService;

@Stateless
@Path("myentities")
public class MyEntitiesResource {

	@Inject
	MyEntityService service;
	
	@GET
	public List<MyEntity> all() {
		return this.service.all();
	}
	
	@GET
	@Path("{id}")
	public MyEntity find(@PathParam("id") long id) {
		return this.service.find(id);
	}
	
	@POST
	public Response save(MyEntity myEnt, @Context UriInfo info) {
		MyEntity created = this.service.save(myEnt);
		
		long id = created.getId();
		URI uri = info.getAbsolutePathBuilder().path("/" + id).build();
		
		return Response.created(uri).build();
	}
}
