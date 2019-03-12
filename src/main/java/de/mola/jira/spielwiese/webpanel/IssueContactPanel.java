package de.mola.jira.spielwiese.webpanel;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.plugin.webfragment.contextproviders.AbstractJiraContextProvider;
import com.atlassian.jira.plugin.webfragment.model.JiraHelper;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.webresource.api.assembler.PageBuilderService;
import de.mola.jira.spielwiese.service.IssueContactService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@Scanned
public class IssueContactPanel extends AbstractJiraContextProvider {

    @ComponentImport
    PageBuilderService pageBuilderService;


    private IssueContactService issueContactService;

    @Autowired
    public IssueContactPanel(PageBuilderService pageBuilderService,
                             IssueContactService issueContactService) {
        this.pageBuilderService = pageBuilderService;
        this.issueContactService = issueContactService;
    }

    @Override
    public Map getContextMap(ApplicationUser applicationUser, JiraHelper jiraHelper) {
        pageBuilderService.assembler().resources().requireContext("issue-contact-panel");
        Map<String, Object> contextParams = jiraHelper.getContextParams();
        Issue issue = (Issue) contextParams.get("issue");
        Long issueId = issue.getId();
        issueContactService.createTestDataForIssue(issueId);
        Map<String, Object> contextMap = new HashMap<>();
        return contextMap;
    }
}
