package de.mola.jira.spielwiese.service;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import de.mola.jira.spielwiese.model.entity.Company;
import de.mola.jira.spielwiese.model.entity.IssueContact;
import de.mola.jira.spielwiese.repository.IssueContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
