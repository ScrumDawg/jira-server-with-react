package de.mola.jira.spielwiese.model.entity;


import net.java.ao.Entity;
import net.java.ao.ManyToMany;
import net.java.ao.schema.Table;

@Table("IssueContact")
public interface IssueContact extends Entity {

    Long getIssueId();
    void setIssueId(Long issueId);

    @ManyToMany(value = IContactToCompany.class )
    Company[] getCompanies();

    @ManyToMany(value = IContactToPerson.class)
    Person[] getPersons();
}
