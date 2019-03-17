package de.mola.jira.spielwiese.model.entity;

import net.java.ao.Entity;
import net.java.ao.ManyToMany;
import net.java.ao.OneToMany;

public interface Contact extends Entity {

    @OneToMany(reverse = "getContact")
    Address[] getAddresses();

    @OneToMany(reverse = "getContact")
    EMailAddress[] getEMailAddresses();

    @OneToMany(reverse = "getContact")
    Telephone[] getTelephones();

    @OneToMany(reverse = "getContact")
    Website[] getWebsites();

    @ManyToMany(value = IssueToContact.class)
    JiraIssue[] getJiraIssues();

    @ManyToMany(value = ProjectToContact.class)
    JiraProject[] getJiraProjects();
}
