package com.jfwf.core.spring.resources.configuration;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component(value = "jfwfContext")
public class JfwfContext {

    private final Map<String, JfwfContextAttribute<?>> nameToAttribute = new ConcurrentHashMap<>();

    public JfwfContextAttribute<?> get(String contextAttributeName) {
        return nameToAttribute.get(contextAttributeName);
    }

    public void setNameToAttribute(String contextAttributeName, JfwfContextAttribute<?> value) {
        nameToAttribute.put(contextAttributeName, value);
    }

}
