package de.mola.jira.spielwiese.model.entity;

import net.java.ao.Entity;

public interface IContactToCompany extends Entity {

    IssueContact getIssueContact();
    void setIssueContact(IssueContact issueContact);

    Company getCompany();
    void setCompany(Company company);
}
