package de.mola.jira.spielwiese.model.entity;

import net.java.ao.Entity;
import net.java.ao.ManyToMany;
import net.java.ao.OneToMany;
import net.java.ao.schema.Table;

@Table("Company")
public interface Company extends Entity {

    String getName();
    void setName(String name);

    String getIndustry();
    void setIndustry(String industry);

    @OneToMany(reverse = "getCompany")
    Address[] getAddresses();

    @OneToMany(reverse = "getCompany")
    EMailAddress[] getEMailAddresses();

    @OneToMany(reverse = "getCompany")
    Telephone[] getTelephones();

    @OneToMany(reverse = "getCompany")
    Website[] getWebsites();

    @ManyToMany(value = IContactToCompany.class)
    IssueContact[] getIssueContacts();
}
