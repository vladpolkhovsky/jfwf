package com.jfwf.core.document.container;

import com.jfwf.core.spring.resources.configuration.JfwfContext;

@FunctionalInterface
public interface JfwfContainer<T> {

    T contextResolver(JfwfContext context);

}
