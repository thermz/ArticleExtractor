package com.example;

import com.tilab.ca.ae.Main;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI.replace("0.0.0.0", "127.0.0.1"));
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetUrl() {
		String testURL="http://espresso.repubblica.it/palazzo/2015/02/25/news/la-grecia-e-la-suggestione-di-uscire-dall-euro-quanto-e-credibile-lo-scenario-di-una-grexit-1.201217";
        String responseMsg = target.path("extraction/echo")
								.queryParam("url", testURL)
								.request().get(String.class);
        assertFalse( responseMsg.isEmpty() );
		System.out.println(responseMsg);
    }
}
