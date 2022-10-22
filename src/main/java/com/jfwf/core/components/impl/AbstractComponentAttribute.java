package com.jfwf.core.components.impl;

import com.jfwf.core.components.ComponentAttribute;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractComponentAttribute implements ComponentAttribute {

    protected String attributeName;

    protected String attributeValue;

    @Override
    public String getAttributeName() {
        return attributeName;
    }

    @Override
    public String getAttributeValue() {
        return attributeValue;
    }

    @Override
    public String render() {
        return getAttributeName() + "=\"" + getAttributeValue() + "\"";
    }

}
