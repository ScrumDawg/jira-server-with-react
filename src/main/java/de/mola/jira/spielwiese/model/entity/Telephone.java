package de.mola.jira.spielwiese.model.entity;

import net.java.ao.Entity;
import net.java.ao.schema.Table;

@Table("Telephone")
public interface Telephone extends Entity {

    String getIdentifier();
    void setIdentifier(String identifier);

    String getTelephoneNumber();
    void setTelephoneNumber(String telephoneNumber);

    Person getPerson();
    void setPerson(Person person);

    Company getCompany();
    void setCompany(Company company);
}
