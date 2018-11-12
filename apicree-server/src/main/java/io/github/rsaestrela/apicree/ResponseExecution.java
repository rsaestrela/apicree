package io.github.rsaestrela.apicree;

import org.apache.http.HttpResponse;

public interface ResponseExecution extends ApicreeExecution<HttpResponse> {

    HttpResponse execute(HttpResponse response);

}
