package de.mola.jira.spielwiese.repository;


import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import de.mola.jira.spielwiese.model.entity.*;
import net.java.ao.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JiraIssueRepository {

    @ComponentImport
    private final ActiveObjects ao;

    @Autowired
    public JiraIssueRepository(ActiveObjects ao) {
        this.ao = ao;
    }

    public Optional<JiraIssue> finById(Integer id){
        Query q = Query.select().where("ID = ?", String.valueOf(id));
        return Optional.ofNullable(ao.find(JiraIssue.class, q)[0]);
    }



    public Optional<JiraIssue> findByIssueId(Long issueId){
        JiraIssue jiraIssue = null;
        Query q = Query.select().where("ISSUE_ID = ?",issueId);
        JiraIssue[] found = ao.find(JiraIssue.class, q);

        if(found.length > 0)
            jiraIssue = found[0];

        return Optional.ofNullable(jiraIssue);
    }

    public void createTestData(Long issueId){
        if(findByIssueId(issueId).isPresent())
            return;

        JiraIssue jiraIssue = createJiraIssue(issueId);

        Company warnerBrothers = createWarnerBrothers();
        Person jamieFoxx = createJamieFoxx();
        Person samuelJackson = createSamuelJackson();

        IssueToContact issueToWarnerBros = ao.create(IssueToContact.class);

        issueToWarnerBros.setJiraIssue(jiraIssue);
        issueToWarnerBros.setContact(warnerBrothers);
        issueToWarnerBros.save();

        IssueToContact issueToJamieFoxx = ao.create(IssueToContact.class);

        issueToJamieFoxx.setJiraIssue(jiraIssue);
        issueToJamieFoxx.setContact(jamieFoxx);
        issueToJamieFoxx.save();

        IssueToContact issueToSamuelJackson = ao.create(IssueToContact.class);

        issueToSamuelJackson.setJiraIssue(jiraIssue);
        issueToSamuelJackson.setContact(samuelJackson);
        issueToSamuelJackson.save();
    }

    private JiraIssue createJiraIssue(Long issueId){
        JiraIssue jiraIssue = ao.create(JiraIssue.class);
        jiraIssue.setIssueId(issueId);
        jiraIssue.save();
        return jiraIssue;
    }

    private Company createWarnerBrothers(){
        Company company = ao.create(Company.class);
        company.setName("Warner Bros. Entertainment");

        EMailAddress eMailAddress = ao.create(EMailAddress.class);
        eMailAddress.setIdentifier("office");
        eMailAddress.setEMailAddress("hr@warner-bros.com");
        eMailAddress.setContact(company);

        eMailAddress.save();
        company.save();
        return company;
    }

    private Person createSamuelJackson(){
        Person person = ao.create(Person.class);
        person.setFirstname("Samuel");
        person.setLastname("Jackson");

        EMailAddress eMailAddress = ao.create(EMailAddress.class);
        eMailAddress.setIdentifier("private");
        eMailAddress.setEMailAddress("s.jackson@gmail.com");
        eMailAddress.setContact(person);

        eMailAddress.save();
        person.save();
        return person;
    }

    private Person createJamieFoxx(){
        Person person = ao.create(Person.class);
        person.setFirstname("Jamie");
        person.setLastname("Foxx");

        EMailAddress eMailAddress = ao.create(EMailAddress.class);
        eMailAddress.setIdentifier("private");
        eMailAddress.setEMailAddress("j.foxx@gmail.com");
        eMailAddress.setContact(person);

        eMailAddress.save();
        person.save();
        return person;
    }

}
