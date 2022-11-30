package com.jfwf.core.html.components.impl.container;

import com.jfwf.core.html.components.Component;
import com.jfwf.core.html.components.ComponentAttribute;
import com.jfwf.core.html.components.impl.AbstractComponent;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@AllArgsConstructor
public abstract class AbstractContainerComponent extends AbstractComponent {

    protected String containerTagName;

    protected Supplier<List<ComponentAttribute>> componentAttributes;

    protected Supplier<List<Component>> subComponents;

    @Override
    protected List<ComponentAttribute> getComponentAttributeList() {
        return componentAttributes.get();
    }

    @Override
    protected String tagName() {
        return containerTagName;
    }

    @Override
    public List<Component> getSubComponents() {
        return subComponents.get();
    }

    @Override
    public String render() {
        return getOpenTag() + renderSubComponents() + getCloseTag();
    }

    private String renderSubComponents() {
        return getSubComponents().stream().map(Component::render).collect(Collectors.joining("\n"));
    }

}
