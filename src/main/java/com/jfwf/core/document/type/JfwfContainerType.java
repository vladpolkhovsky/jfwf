package com.jfwf.core.document.type;

import com.jfwf.core.document.type.builder.JfwfTextContainerTypeBuilder;

public final class JfwfContainerType {

    public static JfwfTextContainerTypeBuilder textContainer() {
        return new JfwfTextContainerTypeBuilder();
    }

}
