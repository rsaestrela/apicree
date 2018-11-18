package io.github.rsaestrela.apicree;

import javax.servlet.http.HttpServletRequest;

public class LogRequestExecution implements RequestExecution {
    @Override
    public HttpServletRequest execute(HttpServletRequest request) {
        System.out.println(request);
        return request;
    }
}
