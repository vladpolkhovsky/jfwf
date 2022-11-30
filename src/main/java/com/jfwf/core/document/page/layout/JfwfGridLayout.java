package com.jfwf.core.document.page.layout;

import com.jfwf.core.document.container.JfwfContainer;
import com.jfwf.core.document.page.layout.builder.JfwfGridLayoutBuilder;

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

}
