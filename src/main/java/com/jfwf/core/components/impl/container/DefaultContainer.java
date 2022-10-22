package com.jfwf.core.components.impl.container;

import com.jfwf.core.components.Component;
import com.jfwf.core.components.ComponentAttribute;

import java.util.List;
import java.util.function.Supplier;

public class DefaultContainer extends AbstractContainerComponent {

    public DefaultContainer(Supplier<List<ComponentAttribute>> componentAttributeList, Supplier<List<Component>> subComponentList) {
        super("div", componentAttributeList, subComponentList);
    }

}
