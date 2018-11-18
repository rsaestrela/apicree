package io.github.rsaestrela.apicree;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ApicreeProxies")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApicreeProxies {

    @XmlElement(name = "Proxy")
    private List<Proxy> proxies;

    public List<Proxy> getProxies() {
        return proxies;
    }

    public void setProxies(List<Proxy> proxies) {
        this.proxies = proxies;
    }
}
