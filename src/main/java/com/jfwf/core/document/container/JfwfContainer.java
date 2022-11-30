package com.jfwf.core.document.container;

import com.jfwf.core.resources.configuration.JfwfContext;

@FunctionalInterface
public interface JfwfContainer<T> {

    T contextResolver(JfwfContext context);

}
