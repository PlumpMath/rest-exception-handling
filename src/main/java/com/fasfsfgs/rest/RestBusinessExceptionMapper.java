package com.fasfsfgs.rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasfsfgs.exception.BusinessException;
import com.fasfsfgs.rest.to.BusinessExceptionTO;
import com.fasfsfgs.rest.util.StackTraceUtils;

@Provider
public class RestBusinessExceptionMapper implements ExceptionMapper<BusinessException> {

  @Override
  public Response toResponse(BusinessException exception) {
    BusinessExceptionTO exceptionTO = new BusinessExceptionTO();
    exceptionTO.setMessage(exception.getMessage());
    exceptionTO.setStackTrace(StackTraceUtils.getStringFromStackTrace(exception));

    return Response.status(Status.FORBIDDEN).entity(exceptionTO).type(MediaType.APPLICATION_JSON)
        .build();
  }

}
