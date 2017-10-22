package com.example.demo.server;

import com.example.demo.service.MultiEntityService;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

@Path("/multi")
@Service
public class MultiEndpoint {

    private MultiEntityService service;

    @Autowired
    public MultiEndpoint(MultiEntityService service) {
        this.service = service;
    }

    @GET
    @Produces("multipart/mixed")
    public MultipartBody getMulti2(@QueryParam("name") String name) {
        List<Attachment> attachments = new LinkedList<>();
        attachments.add(new Attachment("root", "application/json", service.getEntity(name)));
        attachments.add(new Attachment("image", "application/octet-stream", service.getEntityData(name)));
        return new MultipartBody(attachments, true);
    }


}
