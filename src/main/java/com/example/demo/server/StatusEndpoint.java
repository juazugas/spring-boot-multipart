package com.example.demo.server;

import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/status")
@Service
public class StatusEndpoint {

    private static final String OK_MESSAGE = "Ok";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello() {
        return Response.ok(OK_MESSAGE).build();
    } 

}
