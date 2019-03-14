package de.mola.jira.spielwiese.service;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import de.mola.jira.spielwiese.model.entity.Company;
import de.mola.jira.spielwiese.model.entity.IssueContact;
import de.mola.jira.spielwiese.model.entity.Person;
import de.mola.jira.spielwiese.repository.IssueContactRepository;
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

    private final IssueContactRepository issueContactRepository;

    @Autowired
    public IssueContactService(IssueContactRepository issueContactRepository) {
        this.issueContactRepository = issueContactRepository;
    }

    public void createTestDataForIssue(Long issueId){
        issueContactRepository.createTestData(issueId);
    }

    public  List<IssueContactOverview> getContactsForIssue(Long issueId){
        Optional<IssueContact> byIssueId = issueContactRepository.findByIssueId(issueId);
        if(!byIssueId.isPresent())
            return new ArrayList<>();

        IssueContact issueContact = byIssueId.get();
        List<Company> companies = Arrays.asList(issueContact.getCompanies());
        List<Person> persons = Arrays.asList(issueContact.getPersons());
        List<IssueContactOverview> issueContactOverviews = companies.stream()
                .map(this::convertCompanyToIssueContactOverview)
                .collect(Collectors.toList());

        persons.stream()
                .map(this::convertPersonToIssueContactOverview)
                .collect(Collectors.toCollection(() -> issueContactOverviews));

        return issueContactOverviews;
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
