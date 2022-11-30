package com.jfwf.core.document.type;

import com.jfwf.core.document.type.builder.JfwfTextContainerTypeBuilder;
import com.jfwf.core.document.type.enums.TextAlignEnum;
import com.jfwf.core.document.type.enums.TextSizeEnum;

public final class JfwfTextContainerType {

    private final TextSizeEnum textSizeEnum;

    private final TextAlignEnum textAlignEnum;

    public JfwfTextContainerType(TextSizeEnum textSizeEnum, TextAlignEnum textAlignEnum) {
        this.textSizeEnum = textSizeEnum;
        this.textAlignEnum = textAlignEnum;
    }

    public static JfwfTextContainerTypeBuilder getBuilder() {
        return new JfwfTextContainerTypeBuilder();
    }

    public static JfwfTextContainerType getDefault() {
        return new JfwfTextContainerTypeBuilder().build();
    }

    public TextSizeEnum getTextSizeEnum() {
        return textSizeEnum;
    }

    public TextAlignEnum getTextAlignEnum() {
        return textAlignEnum;
    }

}
