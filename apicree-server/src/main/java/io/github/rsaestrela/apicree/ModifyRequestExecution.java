package io.github.rsaestrela.apicree;

public class ModifyRequestExecution<T> implements ApicreeExecution<T> {
    @Override
    public void execute(T t) {
        System.out.println("Modify request");
    }
}
