package com.tilab.ca.ae.rest;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import java.net.MalformedURLException;
import java.net.URL;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 */
@Path("extraction")
public class Extraction {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
	 * @param url
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@QueryParam("url") String url) throws BoilerpipeProcessingException, MalformedURLException {
		URL articleURL = new URL(url);
		System.out.println(articleURL.toString());
		String result;
		try{ 
			result = ArticleExtractor.INSTANCE.getText(articleURL);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
    }
	
	/**
     * Stub method
     *
	 * @param url
     * @return String that will be returned as a text/plain response.
     */
	@Path("echo")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String echo(@QueryParam("url") String url) {
		return "Retrieved correctly "+url;
    }
	
}
