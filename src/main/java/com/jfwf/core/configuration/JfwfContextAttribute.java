package com.jfwf.core.configuration;

public class JfwfContextAttribute<T> {

    private T value;

    public JfwfContextAttribute(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
