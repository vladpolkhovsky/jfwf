package com.jfwf.core.document.page.layout.builder;

import com.jfwf.core.document.container.JfwfContainer;
import com.jfwf.core.document.page.layout.impl.JfwfGridLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JfwfGridLayoutBuilder {

    private final List<JfwfContainer<?>> columns = new ArrayList<>();

    public JfwfGridLayoutBuilder appendColumn(JfwfContainer<?> column) {
        Objects.requireNonNull(column);
        columns.add(column);
        return this;
    }

    public JfwfGridLayout build() {
        return new JfwfGridLayout(columns);
    }

}
