package com.jfwf.core.components.impl.text;

import com.jfwf.core.components.ComponentAttribute;
import lombok.Getter;

import java.util.List;
import java.util.function.Supplier;

@Getter
public class ParagraphComponent extends AbstractTextComponent {

    private static final String PARAGRAPH = "p";

    public ParagraphComponent(Supplier<String> contentSupplier, Supplier<List<ComponentAttribute>> componentAttributeList) {
        super(contentSupplier, componentAttributeList);
    }

    @Override
    protected String tagName() {
        return PARAGRAPH;
    }

}
