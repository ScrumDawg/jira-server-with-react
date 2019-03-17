package de.mola.jira.spielwiese.model.entity;

import net.java.ao.Entity;

public interface IssueToContact extends Entity {

    JiraIssue getJiraIssue();
    void setJiraIssue(JiraIssue jiraIssue);

    Contact getContact();
    void setContact(Contact contact);
}
