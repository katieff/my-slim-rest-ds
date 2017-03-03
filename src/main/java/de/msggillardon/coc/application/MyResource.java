package de.msggillardon.coc.application;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("helloworld")
public class MyResource {

	@GET
	@Produces("text/plain")
	public String hello() {
		return "Hello World!";
	}
}
