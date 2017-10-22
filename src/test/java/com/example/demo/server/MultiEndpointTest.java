package com.example.demo.server;

import com.example.demo.DemoApplication;
import com.example.demo.model.ModelEntity;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static com.example.demo.server.StatusEndpointTest.TEST_PWD;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = { "security.user.password=" + TEST_PWD})
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MultiEndpointTest {

    @LocalServerPort
    private int port;

    @Autowired
    private JacksonJsonProvider jsonProvider;

    @Test
    public void testMethod() {
        WebClient wc = WebClient.create("http://127.0.0.1:" + port + "/services/",
                Collections.singletonList(jsonProvider), "user", TEST_PWD, null);
        WebClient.getConfig(wc).getHttpConduit().getClient().setReceiveTimeout(10000000);
        wc.accept("multipart/mixed");
        wc.path("multi").query("name", "demo");
        MultipartBody body = wc.get(MultipartBody.class);
        ModelEntity entity = body.getRootAttachment().getObject(ModelEntity.class);
        assertEquals("demo", entity.getName());
    }

}
