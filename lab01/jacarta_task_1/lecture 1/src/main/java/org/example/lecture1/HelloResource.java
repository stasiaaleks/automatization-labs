package org.example.lecture1;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/surname")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Aleksieienko";
    }
}