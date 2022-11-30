package com.jfwf.core.document.page.layout.impl;

import com.jfwf.core.document.Renderable;
import com.jfwf.core.document.container.JfwfContainer;
import com.jfwf.core.document.page.layout.JfwfPageLayout;
import com.jfwf.core.html.components.Component;
import com.jfwf.core.html.components.impl.attribute.CustomAttribute;
import com.jfwf.core.html.components.impl.container.DefaultContainer;
import com.jfwf.core.spring.resources.configuration.JfwfContext;

import java.util.List;
import java.util.Objects;

public class JfwfSimpleLayout<T> implements JfwfPageLayout {

    private final JfwfContainer<T> container;

    public JfwfSimpleLayout(JfwfContainer<T> container) {
        Objects.requireNonNull(container);
        this.container = container;
    }

    public static <T> JfwfSimpleLayout<T> of(JfwfContainer<T> container) {
        return new JfwfSimpleLayout<>(container);
    }

    public JfwfContainer<T> getContainer() {
        return container;
    }


    // Снести нахрен
    @Override
    public List<Component> renderedComponent(JfwfContext context) {
        return List.of(new DefaultContainer(
                () -> List.of(CustomAttribute.of("class", "container")),
                () -> ((Renderable) container).renderedComponent(context))
        );
    }
}
