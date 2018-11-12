package io.github.rsaestrela.apicree;

import javax.servlet.http.HttpServletRequest;

public class VerifyRequestExecution implements RequestExecution {
    @Override
    public HttpServletRequest execute(HttpServletRequest request) {
        System.out.println("Verify request");
        return request;
    }
}
