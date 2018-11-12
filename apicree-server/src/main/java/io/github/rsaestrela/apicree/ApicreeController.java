package io.github.rsaestrela.apicree;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@RestController
public class ApicreeController {

    private CloseableHttpClient httpClient = HttpClients.createDefault();

    private final ApicreeProxies apicreeProxies;
    private final ExecutionFactory executionFactory;

    @Autowired
    public ApicreeController(ApicreeProxiesLoader apicreeProxiesLoader, ExecutionFactory executionFactory) {
        this.apicreeProxies = apicreeProxiesLoader.getApicreeProxies();
        this.executionFactory = executionFactory;
    }

    @RequestMapping(path = "**/**", method = RequestMethod.GET)
    public ResponseEntity proxy(HttpServletRequest request) throws IOException {

        String requestURI = request.getRequestURI();
        Optional<Proxy> proxy = getProxy(requestURI);
        if (!proxy.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        executeRequestExecutors(proxy.get(), request);

        HttpResponse proxyResponse;
        try {
            proxyResponse = performProxyCall(proxy.get().getProxy());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        executeResponseExecutors(proxy.get(), proxyResponse);

        return ResponseEntity.ok(IOUtils.toString(proxyResponse.getEntity().getContent(), StandardCharsets.UTF_8.name()));
    }

    private Optional<Proxy> getProxy(String requestURI) {
        for (Proxy proxy : apicreeProxies.getProxies()) {
            if (proxy.getMethod().equals(HttpMethod.GET.name()) && proxy.getPath().equals(requestURI)) {
                return Optional.of(proxy);
            }
        }
        return Optional.empty();
    }

    private void executeRequestExecutors(Proxy proxy, HttpServletRequest request) {
        proxy.getPreExecution().getExecutions().forEach(execution -> {
            String executor = execution.getExecutor();
            RequestExecution requestExecution = (RequestExecution) executionFactory.getExecution(executor);
            requestExecution.execute(request);
        });
    }

    private void executeResponseExecutors(Proxy proxy, HttpResponse response) {
        proxy.getPostExecution().getExecutions().forEach(execution -> {
            String executor = execution.getExecutor();
            ResponseExecution responseExecution = (ResponseExecution) executionFactory.getExecution(executor);
            responseExecution.execute(response);
        });
    }

    private HttpResponse performProxyCall(String proxy) throws IOException {
        HttpGet httpGet = new HttpGet(proxy);
        return httpClient.execute(httpGet);
    }

}
