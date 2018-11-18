package io.github.rsaestrela.apicree;

import org.apache.http.HttpResponse;

public class LogResponseExecution implements ResponseExecution {
    @Override
    public HttpResponse execute(HttpResponse response) {
        System.out.println(response.toString());
        return response;
    }
}
