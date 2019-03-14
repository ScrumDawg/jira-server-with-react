package de.mola.jira.spielwiese.repository;


import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import de.mola.jira.spielwiese.model.entity.*;
import net.java.ao.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class IssueContactRepository {

    @ComponentImport
    private final ActiveObjects ao;

    @Autowired
    public IssueContactRepository(ActiveObjects ao) {
        this.ao = ao;
    }

    public Optional<IssueContact> finById(Integer id){
        Query q = Query.select().where("ID = %s", String.valueOf(id));
        return Optional.ofNullable(ao.find(IssueContact.class, q)[0]);
    }



    public Optional<IssueContact> findByIssueId(Long issueId){
        IssueContact issueContact = null;
        Query q = Query.select().where("ISSUE_ID = ?",issueId);
        IssueContact[] found = ao.find(IssueContact.class, q);

        if(found.length > 0)
            issueContact = found[0];

        return Optional.ofNullable(issueContact);
    }

    public void createTestData(Long issueId){
        if(findByIssueId(issueId).isPresent())
            return;

        IssueContact issueContact = createIssueContact(issueId);

        Company warnerBrothers = createWarnerBrothers();
        Person jamieFoxx = createJamieFoxx();
        Person samuelJackson = createSamuelJackson();

        IContactToCompany iContactToCompany = ao.create(IContactToCompany.class);
        iContactToCompany.setIssueContact(issueContact);
        iContactToCompany.setCompany(warnerBrothers);
        iContactToCompany.save();

        IContactToPerson iContactToPerson = ao.create(IContactToPerson.class);
        iContactToPerson.setIssueContact(issueContact);
        iContactToPerson.setPerson(jamieFoxx);
        iContactToPerson.save();

        IContactToPerson iContactToPerson2 = ao.create(IContactToPerson.class);
        iContactToPerson2.setIssueContact(issueContact);
        iContactToPerson2.setPerson(samuelJackson);
        iContactToPerson2.save();
    }

    private IssueContact createIssueContact(Long issueId){
        IssueContact issueContact = ao.create(IssueContact.class);
        issueContact.setIssueId(issueId);
        issueContact.save();
        return issueContact;
    }

    private Company createWarnerBrothers(){
        Company company = ao.create(Company.class);
        company.setName("Warner Bros. Entertainment");

        EMailAddress eMailAddress = ao.create(EMailAddress.class);
        eMailAddress.setIdentifier("office");
        eMailAddress.setEMailAddress("hr@warner-bros.com");
        eMailAddress.setCompany(company);

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
        eMailAddress.setPerson(person);

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
        eMailAddress.setPerson(person);

        eMailAddress.save();
        person.save();
        return person;
    }

}
