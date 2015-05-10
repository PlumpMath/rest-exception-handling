package com.fasfsfgs.rest.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasfsfgs.entity.Entity01;
import com.fasfsfgs.exception.BusinessException;

@Path("/entities01")
public class Entity01RestService {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Entity01> getAll() {
    List<Entity01> entities01 = new ArrayList<Entity01>();
    entities01.add(new Entity01(1, "Test 01", false));
    entities01.add(new Entity01(2, "Test 02", true));

    return entities01;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Entity01 create(Entity01 entity01) {
    throw new RuntimeException("No database found!");
  }

  @DELETE
  @Path("/{id}")
  public void get(@PathParam("id") Integer id) {
    StringBuilder businessMessage = new StringBuilder();
    businessMessage.append("The entity01 \"");
    businessMessage.append(id);
    businessMessage.append("\" could not be deleted because it's used by some other resource.");

    throw new BusinessException(businessMessage.toString());
  }

}
