package de.mola.jira.spielwiese.model.entity;

import net.java.ao.Entity;

public interface IContactToPerson extends Entity {

    IssueContact getIssueContact();
    void setIssueContact(IssueContact issueContact);

    Person getPerson();
    void setPerson(Person person);
}
