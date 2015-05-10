package com.fasfsfgs.rest;

import java.util.Random;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasfsfgs.rest.to.DefaultExceptionTO;
import com.fasfsfgs.rest.util.StackTraceUtils;

@Provider
public class RestDefaultExceptionMapper implements ExceptionMapper<Throwable> {

  @Override
  public Response toResponse(Throwable exception) {
    exception.printStackTrace();

    DefaultExceptionTO exceptionTO = new DefaultExceptionTO();
    exceptionTO.setId(new Random().nextInt(10000));
    exceptionTO.setStackTrace(StackTraceUtils.getStringFromStackTrace(exception));

    return Response.status(Status.INTERNAL_SERVER_ERROR).entity(exceptionTO)
        .type(MediaType.APPLICATION_JSON).build();
  }

}
