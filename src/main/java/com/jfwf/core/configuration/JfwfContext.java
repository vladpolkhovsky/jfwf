package com.jfwf.core.configuration;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

@Scope(value = "session")
@Component(value = "jfwfContext")
public class JfwfContext {

    private final Map<String, AtomicReference<JfwfContextAttribute<?>>> nameToAttribute = new ConcurrentHashMap<>();

    AtomicReference<JfwfContextAttribute<?>> get(String contextAttributeName) {
        return nameToAttribute.get(contextAttributeName);
    }

    public void setNameToAttribute(String contextAttributeName, JfwfContextAttribute<?> value) {
        nameToAttribute.put(contextAttributeName, new AtomicReference<>(value));
    }

}
