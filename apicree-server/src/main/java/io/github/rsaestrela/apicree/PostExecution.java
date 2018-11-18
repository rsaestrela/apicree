package io.github.rsaestrela.apicree;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "PostExecution")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostExecution {

    @XmlElement(name = "Execution")
    private List<Execution> executions;

    public List<Execution> getExecutions() {
        return executions;
    }

    public void setExecutions(List<Execution> executions) {
        this.executions = executions;
    }

}
