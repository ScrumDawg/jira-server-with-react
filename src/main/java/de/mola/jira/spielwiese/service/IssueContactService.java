package de.mola.jira.spielwiese.service;

import de.mola.jira.spielwiese.model.entity.Company;
import de.mola.jira.spielwiese.model.entity.Contact;
import de.mola.jira.spielwiese.model.entity.JiraIssue;
import de.mola.jira.spielwiese.model.entity.Person;
import de.mola.jira.spielwiese.repository.JiraIssueRepository;
import de.mola.jira.spielwiese.rest.payload.response.IssueContactOverview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IssueContactService {

    private final JiraIssueRepository jiraIssueRepository;

    @Autowired
    public IssueContactService(JiraIssueRepository jiraIssueRepository) {
        this.jiraIssueRepository = jiraIssueRepository;
    }

    public void createTestDataForIssue(Long issueId){
        jiraIssueRepository.createTestData(issueId);
    }

    public  List<IssueContactOverview> getContactsForIssue(Long issueId){
        Optional<JiraIssue> byIssueId = jiraIssueRepository.findByIssueId(issueId);
        if(!byIssueId.isPresent())
            return new ArrayList<>();

        JiraIssue jiraIssue = byIssueId.get();
        List<Contact> contacts = Arrays.asList(jiraIssue.getContacts());
        List<IssueContactOverview> issueContactOverviews = contacts.stream()
                .map(this::convertContactToIssueContactOverview)
                .collect(Collectors.toList());
        return issueContactOverviews;
    }

    private IssueContactOverview convertContactToIssueContactOverview(Contact contact){

        if(contact instanceof Company)
            return convertCompanyToIssueContactOverview((Company) contact);
        if(contact instanceof Person)
            return convertPersonToIssueContactOverview((Person) contact);

        return null;
    }

    private IssueContactOverview convertCompanyToIssueContactOverview(Company company){
        return IssueContactOverview.builder()
                .id(company.getID())
                .name(company.getName())
                .type("company")
                .email(Arrays.asList(
                        company.getEMailAddresses()).stream()
                        .map(eMailAddress -> eMailAddress.getEMailAddress())
                        .collect(Collectors.toList()))
                .build();

    }

    private IssueContactOverview convertPersonToIssueContactOverview(Person person){
        return IssueContactOverview.builder()
                .id(person.getID())
                .name(person.getFirstname() + " " + person.getLastname())
                .type("company")
                .email(Arrays.asList(
                        person.getEMailAddresses()).stream()
                        .map(eMailAddress -> eMailAddress.getEMailAddress())
                        .collect(Collectors.toList()))
                .build();

    }

}
