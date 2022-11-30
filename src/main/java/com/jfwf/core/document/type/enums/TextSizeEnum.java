package com.jfwf.core.document.type.enums;

public enum TextSizeEnum {

    SMALL(10, 5),

    NORMAL(14, 3),

    BIG(18, 2),

    LARGE(25, 1),

    ;

    private final int remSize;

    private final int headerLevel;

    TextSizeEnum(int remSize, int headerLevel) {
        this.remSize = remSize;
        this.headerLevel = headerLevel;
    }

    public int getRemSize() {
        return remSize;
    }

    public int getHeaderLevel() {
        return headerLevel;
    }
}
