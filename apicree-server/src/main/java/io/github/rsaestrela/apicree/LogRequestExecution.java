package io.github.rsaestrela.apicree;

public class LogRequestExecution<T> implements ApicreeExecution<T> {
    @Override
    public void execute(T t) {
        System.out.println(t);
    }
}
