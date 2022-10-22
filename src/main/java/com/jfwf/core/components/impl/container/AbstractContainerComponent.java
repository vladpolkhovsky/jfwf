package com.jfwf.core.components.impl.container;

import com.jfwf.core.components.Component;
import com.jfwf.core.components.ComponentAttribute;
import com.jfwf.core.components.impl.AbstractComponent;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@AllArgsConstructor
public abstract class AbstractContainerComponent extends AbstractComponent {

    protected String containerTagName;

    protected Supplier<List<ComponentAttribute>> componentAttribute;

    protected Supplier<List<Component>> subComponent;

    @Override
    protected List<ComponentAttribute> getComponentAttributeList() {
        return componentAttribute.get();
    }

    @Override
    protected String tagName() {
        return containerTagName;
    }

    @Override
    public List<Component> getSubComponents() {
        return subComponent.get();
    }

    @Override
    public String render() {
        return getOpenTag() + renderSubComponents() + getCloseTag();
    }

    private String renderSubComponents() {
        return getSubComponents().stream().map(Component::render).collect(Collectors.joining("\n"));
    }

}
