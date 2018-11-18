package io.github.rsaestrela.apicree;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Proxy")
@XmlAccessorType(XmlAccessType.FIELD)
public class Proxy {

    @XmlAttribute
    private String path;

    @XmlAttribute
    private String proxy;

    @XmlAttribute
    private String method;

    @XmlElement(name = "PreExecution")
    private PreExecution preExecution;

    @XmlElement(name = "PostExecution")
    private PostExecution postExecution;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public PreExecution getPreExecution() {
        return preExecution;
    }

    public void setPreExecution(PreExecution preExecution) {
        this.preExecution = preExecution;
    }

    public PostExecution getPostExecution() {
        return postExecution;
    }

    public void setPostExecution(PostExecution postExecution) {
        this.postExecution = postExecution;
    }
}
