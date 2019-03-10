package de.mola.jira.spielwiese.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/issuecontact")
public class IssueContactRestController {

    @GET
    public Response getIssueContactForIssue(@QueryParam("issueId") String issueId){
        return null;
    }
}
