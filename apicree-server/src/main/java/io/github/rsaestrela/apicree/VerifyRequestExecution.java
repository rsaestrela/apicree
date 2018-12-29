package io.github.rsaestrela.apicree;

public class VerifyRequestExecution<T> implements ApicreeExecution<T> {
    @Override
    public void execute(T request) {
        System.out.println("Verify request");
    }
}
