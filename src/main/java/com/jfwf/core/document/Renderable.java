package com.jfwf.core.document;

import com.jfwf.core.html.components.Component;
import com.jfwf.core.spring.resources.configuration.JfwfContext;

import java.util.List;

public interface Renderable {

    List<Component> renderedComponent(JfwfContext context);

}
