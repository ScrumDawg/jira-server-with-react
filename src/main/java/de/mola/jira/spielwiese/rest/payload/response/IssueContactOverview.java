package de.mola.jira.spielwiese.rest.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class IssueContactOverview {

    @XmlElement
    private String name;

    @XmlElementWrapper
    @XmlElement(name="keyword")
    private List<String> email;

    @XmlElement
    private String type;
}
