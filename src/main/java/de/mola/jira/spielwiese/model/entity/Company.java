package de.mola.jira.spielwiese.model.entity;

import net.java.ao.Entity;
import net.java.ao.ManyToMany;
import net.java.ao.OneToMany;
import net.java.ao.schema.Table;

@Table("Company")
public interface Company extends Contact {

    String getName();
    void setName(String name);

    String getIndustry();
    void setIndustry(String industry);

    @ManyToMany(value = IssueToContact.class)
    JiraIssue[] getJiraIssues();
}
