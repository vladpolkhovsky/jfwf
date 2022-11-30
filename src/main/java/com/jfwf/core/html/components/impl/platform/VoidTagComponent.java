package com.jfwf.core.html.components.impl.platform;

import com.jfwf.core.html.components.Component;
import com.jfwf.core.html.components.ComponentAttribute;
import com.jfwf.core.html.components.impl.AbstractComponent;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class VoidTagComponent extends AbstractComponent {

    private final String tagName;

    private final List<ComponentAttribute> componentAttributes;

    public VoidTagComponent(String tagName, Supplier<List<ComponentAttribute>> componentAttributes) {
        this.tagName = tagName;
        this.componentAttributes = componentAttributes.get();
    }

    @Override
    public List<Component> getSubComponents() {
        return Collections.emptyList();
    }

    @Override
    public String render() {
        return "<" + tagName() + " " + renderAttributes() + " />";
    }

    @Override
    protected String tagName() {
        return tagName;
    }

    @Override
    protected List<ComponentAttribute> getComponentAttributeList() {
        return componentAttributes;
    }
}
