package de.mola.jira.spielwiese.rest;

import de.mola.jira.spielwiese.rest.payload.response.IssueContactOverview;
import de.mola.jira.spielwiese.service.IssueContactService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/issuecontact")
public class IssueContactRestController {

    @Autowired
    private IssueContactService issueContactService;


    @GET
    public Response getIssueContactForIssue(@QueryParam("issueId") String issueId){
        Long issueIdLong = Long.valueOf(issueId);
        List<IssueContactOverview> contactsForIssue = issueContactService.getContactsForIssue(issueIdLong);
        return Response.ok(contactsForIssue).build();
    }
}
