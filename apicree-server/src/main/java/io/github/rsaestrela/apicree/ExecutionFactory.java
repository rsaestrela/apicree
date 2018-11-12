package io.github.rsaestrela.apicree;

import org.springframework.stereotype.Component;

@Component
public class ExecutionFactory {

    public ApicreeExecution getExecution(String executor) {
        if (executor.equals("LogRequest")) {
            return new LogRequestExecution();
        }
        if (executor.equals("VerifyRequest")) {
            return new VerifyRequestExecution();
        }
        if (executor.equals("ModifyRequest")) {
            return new ModifyRequestExecution();
        }
        if (executor.equals("LogResponse")) {
            return new LogResponseExecution();
        }
        throw new IllegalStateException(String.format("Execution %s is not available", executor));
    }

}
