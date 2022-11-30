package com.jfwf.core.html.components.impl.container;

import com.jfwf.core.html.components.Component;
import com.jfwf.core.html.components.ComponentAttribute;

import java.util.List;
import java.util.function.Supplier;

public class DefaultContainer extends AbstractContainerComponent {

    public DefaultContainer(Supplier<List<ComponentAttribute>> componentAttributeList, Supplier<List<Component>> subComponentList) {
        super("div", componentAttributeList, subComponentList);
    }

}
