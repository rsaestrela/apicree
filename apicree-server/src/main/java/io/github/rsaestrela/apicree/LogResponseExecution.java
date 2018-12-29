package io.github.rsaestrela.apicree;

public class LogResponseExecution<T> implements ApicreeExecution<T> {
    @Override
    public void execute(T t) {
        System.out.println(t.toString());
    }
}
