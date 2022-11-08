package com.jfwf.core.components.impl.platform;

import com.jfwf.core.components.Component;
import com.jfwf.core.components.ComponentAttribute;
import com.jfwf.core.components.impl.container.AbstractContainerComponent;

import java.util.List;
import java.util.function.Supplier;

public final class HtmlHeadComponent extends AbstractContainerComponent {

    private static final String HEAD_TAG_NAME = "head";

    public HtmlHeadComponent(Supplier<List<ComponentAttribute>> componentAttribute, Supplier<List<Component>> subComponent) {
        super(HEAD_TAG_NAME, componentAttribute, subComponent);
    }


    //TODO переписать.
    @Override
    public String render() {
        String result = """
                    <meta charset="utf-8">
                    <meta content="width=device-width, initial-scale=1" name="viewport">
                    <link href="/web/favicon.ico" rel="icon" type="image/x-icon">
                    <link href="/web/css/bootstrap.min.css" rel="stylesheet">
                    <title>Welcome to JFWF framework</title>
                    
                """;
        return result + super.render();
    }
}
