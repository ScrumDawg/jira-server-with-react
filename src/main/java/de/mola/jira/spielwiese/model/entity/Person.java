package de.mola.jira.spielwiese.model.entity;

import net.java.ao.Entity;
import net.java.ao.ManyToMany;
import net.java.ao.OneToMany;
import net.java.ao.schema.Table;

import java.util.Date;

@Table("Person")
public interface Person extends Entity {

    String getFirstname();
    void setFirstname(String firstname);

    String getLastname();
    void setLastname(String lastname);

    Date getBirthdate();
    void setBirthdate(Date birthdate);

    String getPosition();
    void setPosition(String position);

    @OneToMany(reverse = "getPerson")
    Address[] getAddresses();

    @OneToMany(reverse = "getPerson")
    EMailAddress[] getEMailAddresses();

    @OneToMany(reverse = "getPerson")
    Telephone[] getTelephones();

    @OneToMany(reverse = "getPerson")
    Website[] getWebsites();

    @ManyToMany(value = IContactToPerson.class)
    IssueContact[] getIssueContacts();
}
