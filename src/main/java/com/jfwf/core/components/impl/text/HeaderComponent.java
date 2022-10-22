package com.jfwf.core.components.impl.text;

import com.jfwf.core.components.ComponentAttribute;

import java.util.List;
import java.util.function.Supplier;

public class HeaderComponent extends AbstractTextComponent {

    private static final String HEADER = "h";

    private final int headerLevel;

    public HeaderComponent(Supplier<String> contentSupplier, Supplier<List<ComponentAttribute>> componentAttributeList, int headerLevel) {
        super(contentSupplier, componentAttributeList);
        this.headerLevel = headerLevel;
    }

    @Override
    protected String tagName() {
        return HEADER + headerLevel;
    }

}
