package de.mola.jira.spielwiese.rest;

import de.mola.jira.spielwiese.rest.dto.PersonDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class RestController {

    @GET
    @Path("person")
    public Response getAllPersons() {
        return Response.ok(new PersonDto("Fred","Bloggs")).build();
    }
}
