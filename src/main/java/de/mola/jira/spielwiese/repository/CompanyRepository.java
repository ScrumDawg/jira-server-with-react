package de.mola.jira.spielwiese.repository;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import de.mola.jira.spielwiese.model.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;

public class CompanyRepository extends AORepository<Company> {


    @Autowired
    public CompanyRepository(@ComponentImport ActiveObjects ao) {
        super(ao);
    }


}
