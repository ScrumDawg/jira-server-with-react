package de.mola.jira.spielwiese.model.entity;

import net.java.ao.Entity;
import net.java.ao.schema.Table;

@Table("EMailAddress")
public interface EMailAddress extends Entity {

    String getIdentifier();
    void setIdentifier(String identifier);

    String getEMailAddress();
    void setEMailAddress(String eMailAddress);

    Contact getContact();
    void setContact(Contact contact);
}
