package io.github.rsaestrela.apicree;

public class Proxy {

    private String path;

    private String proxy;

    private String method;

    private PreExecution preExecution;

    private PreExecution postExecution;

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

    public PreExecution getPostExecution() {
        return postExecution;
    }

    public void setPostExecution(PreExecution postExecution) {
        this.postExecution = postExecution;
    }
}
