package de.mola.jira.spielwiese.model.entity;

import net.java.ao.Entity;
import net.java.ao.ManyToMany;

public interface JiraProject extends Entity {

    Long getProjectId();
    void setProjectId();

    @ManyToMany(value = ProjectToContact.class )
    Contact[] getContacts();
}
