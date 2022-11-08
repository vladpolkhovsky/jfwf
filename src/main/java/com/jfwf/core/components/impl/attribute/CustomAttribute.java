package com.jfwf.core.components.impl.attribute;

import com.jfwf.core.components.impl.AbstractComponentAttribute;

public class CustomAttribute extends AbstractComponentAttribute {

    public CustomAttribute(String attributeName, String attributeValue) {
        super(attributeName, attributeValue);
    }

    public static final CustomAttribute of(String key, String value) {
        return new CustomAttribute(key, value);
    }

}
