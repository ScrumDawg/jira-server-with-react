package de.mola.jira.spielwiese.contextprovider;

import com.atlassian.plugin.PluginParseException;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.plugin.web.ContextProvider;
import com.atlassian.webresource.api.assembler.PageBuilderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Scanned
public class CRMPanelContextProvider implements ContextProvider {

    @ComponentImport
    PageBuilderService pageBuilderService;

    @Autowired
    public CRMPanelContextProvider(PageBuilderService pageBuilderService) {
        this.pageBuilderService = pageBuilderService;
    }

    @Override
    public void init(Map<String, String> params) throws PluginParseException {

    }

    @Override
    public Map<String, Object> getContextMap(Map<String, Object> context) {
        pageBuilderService.assembler().resources().requireWebResource("de.mola.jira.spielwiese.myplugin:main-react");
        return context;
    }
}
