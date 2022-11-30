package com.jfwf.core.html.components.impl.text;

import com.jfwf.core.html.components.Component;
import com.jfwf.core.html.components.ComponentAttribute;
import com.jfwf.core.html.components.impl.AbstractComponent;
import lombok.AllArgsConstructor;
import org.apache.commons.collections4.ListUtils;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

@AllArgsConstructor
public abstract class AbstractTextComponent extends AbstractComponent {

    protected Supplier<String> contentSupplier;

    protected Supplier<List<ComponentAttribute>> componentAttributeList;

    @Override
    protected List<ComponentAttribute> getComponentAttributeList() {
        return ListUtils.emptyIfNull(componentAttributeList.get());
    }

    @Override
    public List<Component> getSubComponents() {
        return Collections.emptyList();
    }

    @Override
    public String render() {
        return getOpenTag() + contentSupplier.get() + getCloseTag();
    }

}
