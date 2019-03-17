package de.mola.jira.spielwiese.model.entity;


import net.java.ao.Entity;
import net.java.ao.ManyToMany;
import net.java.ao.schema.Table;

@Table("JiraIssue")
public interface JiraIssue extends Entity {

    Long getIssueId();
    void setIssueId(Long issueId);

    JiraProject getJiraProject();
    void setJiraProject(JiraProject jiraProject);

    @ManyToMany(value = IssueToContact.class )
    Contact[] getContacts();
}
