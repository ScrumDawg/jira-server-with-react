package de.mola.jira.spielwiese.webwork;


import com.atlassian.jira.bc.project.ProjectService;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.jira.web.action.JiraWebActionSupport;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.webresource.api.assembler.PageBuilderService;
import org.springframework.beans.factory.annotation.Autowired;

@Scanned
public class ExampleAdminPage extends JiraWebActionSupport {

    @ComponentImport
    private JiraAuthenticationContext authenticationContext;
    @ComponentImport
    private PageBuilderService pageBuilderService;
    @ComponentImport
    private ProjectService projectService;

    @Autowired
    public ExampleAdminPage(JiraAuthenticationContext authenticationContext, PageBuilderService pageBuilderService, ProjectService projectService) {
        this.authenticationContext = authenticationContext;
        this.pageBuilderService = pageBuilderService;
        this.projectService = projectService;
    }

    public ExampleAdminPage(){
    }

    @Override
    public String doDefault() throws Exception {
        pageBuilderService.assembler().resources().requireWebResource("de.mola.jira.spielwiese.myplugin:main-react");
        pageBuilderService.assembler().resources().requireWebResource("de.mola.jira.spielwiese.myplugin:main-react-loader");
        pageBuilderService.assembler().resources().requireWebResource("de.mola.jira.spielwiese.myplugin:img");
        return "example";
    }


}
