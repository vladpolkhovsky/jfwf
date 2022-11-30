package com.jfwf.core.document.page.layout.impl;

import com.jfwf.core.document.Renderable;
import com.jfwf.core.document.container.JfwfContainer;
import com.jfwf.core.document.page.layout.JfwfPageLayout;
import com.jfwf.core.document.page.layout.builder.JfwfGridLayoutBuilder;
import com.jfwf.core.html.components.Component;
import com.jfwf.core.html.components.impl.attribute.CustomAttribute;
import com.jfwf.core.html.components.impl.container.DefaultContainer;
import com.jfwf.core.spring.resources.configuration.JfwfContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JfwfGridLayout implements JfwfPageLayout {

    private List<JfwfContainer<?>> columns = new ArrayList<>();

    public JfwfGridLayout(List<JfwfContainer<?>> columns) {
        Objects.requireNonNull(columns);
        this.columns = columns;
    }

    public static JfwfGridLayoutBuilder getBuilder() {
        return new JfwfGridLayoutBuilder();
    }

    @Override
    public List<Component> renderedComponent(JfwfContext context) {

        List<DefaultContainer> cols = columns.stream()
                .map(jfwfContainer -> ((Renderable) jfwfContainer).renderedComponent(context))
                .map(colContent -> new DefaultContainer(() -> List.of(CustomAttribute.of("class", "col")), () -> colContent))
                .toList();

        DefaultContainer row = new DefaultContainer(() -> List.of(CustomAttribute.of("class", "row")), () -> cols.stream().map(f -> (Component) f).toList());

        DefaultContainer container = new DefaultContainer(() -> List.of(CustomAttribute.of("class", "container")), () -> List.of(row));

        return List.of(container);
    }
}
