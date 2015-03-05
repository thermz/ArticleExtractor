**AE** is an HTTP RESTful service implemented in Java that provide article extraction from an input URL. 
The URL is URL-encoded using UTF-8.

It is a simple Jersey REST JAX-RS service packaged as a **fat JAR**, via the Maven Shade plugin.
It runs with an embedded HTTP server.
( Reference: https://jersey.java.net/documentation/latest/getting-started.html )

If you have a JRE 8, you can simply run AE using the Main class
```
java -cp ArticleExtractor-{$version}.jar com.tilab.ca.ae.Main
```
In the current implementation (2015-03-05) it will listen at port 8089 and will accept any request from any address.

You'd want to invoke the AE with an HTTP GET at:

```
http://YOUR_BASE_URI/ae/extraction?url=$encoded_HTTP_URL_of_an_article_you_want_to_extract
```

At localhost it should be something like:

```
http://127.0.0.1:8089/ae/extraction?url=$encoded_HTTP_URL_of_an_article_you_want_to_extract
```
