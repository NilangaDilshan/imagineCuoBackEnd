package com.excelResearchers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;



public class Main {
	private final static Logger logger = Logger.getLogger(Main.class);
	public static final String BASE_URI = "http://localhost:8080/myapp/";
	private static URI uri = null;

	public static HttpServer startServer() {
		final ResourceConfig rc = new ResourceConfig()
				.packages("com.excelResearchers.controllers");
		try {
			uri = new URI("http", null, BasicConfigs.props.getProperty("host"),
					Integer.parseInt(BasicConfigs.props.getProperty("port")),
					BasicConfigs.props.getProperty("path"), null, null);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return GrizzlyHttpServerFactory.createHttpServer(uri, rc);
	}

	public static void main(String[] args) throws IOException {
		BasicConfigs.setProperties();
		final HttpServer server = startServer();
		try {
			server.start();
			logger.info(String.format(
					"Jersey app started with WADL available at "
							+ "%s/application.wadl\nHit enter to stop it...",
					uri));
			Thread.currentThread().join();
		} catch (IOException | InterruptedException ex) {
			logger.info("Server Stopped! " + ex.getMessage());
		}
		// StatCronTriger.startProcess();
		// StatCronTriger.stopScheduler();
	}

}
