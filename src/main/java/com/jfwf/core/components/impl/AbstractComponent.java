package com.jfwf.core.components.impl;

import com.jfwf.core.components.Component;
import com.jfwf.core.components.ComponentAttribute;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@NoArgsConstructor
public abstract class AbstractComponent implements Component {

    protected abstract String tagName();

    protected abstract List<ComponentAttribute> getComponentAttributeList();

    public String getOpenTag() {
        return "<" + tagName() + " " + renderAttributes() + ">";
    }

    public String getCloseTag() {
        return "</" + tagName() + ">";
    }

    private String renderAttributes() {
        List<String> renderedAttributes = CollectionUtils.emptyIfNull(getComponentAttributeList()).stream()
                .map(ComponentAttribute::render).toList();
        return StringUtils.join(renderedAttributes, " ");
    }

}