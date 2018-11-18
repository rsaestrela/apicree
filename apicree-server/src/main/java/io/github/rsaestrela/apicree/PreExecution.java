package io.github.rsaestrela.apicree;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "PreExecution")
@XmlAccessorType(XmlAccessType.FIELD)
public class PreExecution {

    @XmlElement(name = "Execution")
    private List<Execution> executions;

    public List<Execution> getExecutions() {
        return executions;
    }

    public void setExecutions(List<Execution> executions) {
        this.executions = executions;
    }
}
