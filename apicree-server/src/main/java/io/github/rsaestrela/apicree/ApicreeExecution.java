package io.github.rsaestrela.apicree;

@FunctionalInterface
public interface ApicreeExecution<T> {
    void execute(T t);
}