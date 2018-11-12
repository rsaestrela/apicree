package io.github.rsaestrela.apicree;

import javax.servlet.http.HttpServletRequest;

public class ModifyRequestExecution implements RequestExecution {
    @Override
    public HttpServletRequest execute(HttpServletRequest request) {
        System.out.println("Modify request");
        return request;
    }
}
