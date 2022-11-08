package com.jfwf.core.components.impl.platform;

import com.jfwf.core.components.Component;
import com.jfwf.core.components.ComponentAttribute;
import com.jfwf.core.components.impl.container.AbstractContainerComponent;

import java.util.List;
import java.util.function.Supplier;

public final class HtmlBodyComponent extends AbstractContainerComponent {

    private static final String BODY_TAG_NAME = "body";

    public HtmlBodyComponent(Supplier<List<ComponentAttribute>> componentAttribute, Supplier<List<Component>> subComponent) {
        super(BODY_TAG_NAME, componentAttribute, subComponent);
    }

}
