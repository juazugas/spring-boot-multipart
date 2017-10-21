package com.example.demo.server;

import com.example.demo.DemoApplication;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.core.Response;

import static com.example.demo.server.StatusEndpointTest.TEST_PWD;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = { "security.user.password=" + TEST_PWD})
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StatusEndpointTest {

    public static final String TEST_PWD = "testpwd";

    @LocalServerPort
    private int port;

    @Test
    public void testStatusRequest() {
        WebClient wc = WebClient.create("http://127.0.0.1:" + port + "/services/", "user", TEST_PWD, null);
        wc.accept("text/plain");

        wc.path("/status");
        String status = wc.get(String.class);
        Assert.assertEquals("Ok", status);

    }

}
