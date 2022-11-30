package com.jfwf.core.document.page.layout;

import com.jfwf.core.document.container.JfwfContainer;

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

}
