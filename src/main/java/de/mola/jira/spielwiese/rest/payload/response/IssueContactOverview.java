package de.mola.jira.spielwiese.rest.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
public class IssueContactOverview {

    @XmlElement
    private Integer id;

    @XmlElement
    private String name;

    @XmlElementWrapper
    @XmlElement(name="email")
    private List<String> email;

    @XmlElement
    private String type;
}
