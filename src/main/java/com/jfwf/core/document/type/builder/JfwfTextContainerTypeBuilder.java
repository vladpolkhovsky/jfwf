package com.jfwf.core.document.type.builder;

import com.jfwf.core.document.type.JfwfTextContainerType;
import com.jfwf.core.document.type.enums.TextAlignEnum;
import com.jfwf.core.document.type.enums.TextSizeEnum;

import java.util.Objects;

public class JfwfTextContainerTypeBuilder {

    private TextSizeEnum textSize = TextSizeEnum.NORMAL;

    private TextAlignEnum textAlign = TextAlignEnum.LEFT;

    public JfwfTextContainerTypeBuilder() {

    }

    public JfwfTextContainerTypeBuilder size(TextSizeEnum textSize) {
        Objects.requireNonNull(textSize);
        this.textSize = textSize;
        return this;
    }

    public JfwfTextContainerTypeBuilder align(TextAlignEnum textAlign) {
        Objects.requireNonNull(textAlign);
        this.textAlign = textAlign;
        return this;
    }

    public JfwfTextContainerType build() {
        return new JfwfTextContainerType(textSize, textAlign);
    }

}
