package de.mola.jira.spielwiese.model.entity;

import net.java.ao.Entity;
import net.java.ao.schema.Table;

import java.net.URL;

@Table("Website")
public interface Website extends Entity {

    String getIdentifier();
    void setIdentifier(String identifier);

    URL getWebsiteURL();
    void setWebsiteURL(URL websiteURL);

    Contact getContact();
    void setContact(Contact contact);
}
