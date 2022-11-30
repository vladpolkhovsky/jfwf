package com.jfwf.core.html.components.impl.platform;

import com.jfwf.core.html.components.Component;
import com.jfwf.core.html.components.ComponentAttribute;
import com.jfwf.core.html.components.impl.attribute.CustomAttribute;
import com.jfwf.core.html.components.impl.container.AbstractContainerComponent;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public final class HtmlHeadComponent extends AbstractContainerComponent {

    private static final String HEAD_TAG_NAME = "head";

    private static final String META_TAG_NAME = "meta";

    private static final String LINK_TAG_NAME = "link";

    private static final List<Component> DEFAULT_COMPONENTS = List.of(
            new VoidTagComponent(META_TAG_NAME, () -> List.of(CustomAttribute.of("charset", "utf-8"))),

            new VoidTagComponent(META_TAG_NAME, () -> List.of(
                    CustomAttribute.of("content", "width=device-width, initial-scale=1"),
                    CustomAttribute.of("name", "viewport"))),

            new VoidTagComponent(LINK_TAG_NAME, () -> List.of(
                    CustomAttribute.of("href", "/web/favicon.ico"),
                    CustomAttribute.of("type", "image/x-icon"))),

            new VoidTagComponent(LINK_TAG_NAME, () -> List.of(
                    CustomAttribute.of("href", "/web/css/bootstrap.min.css"),
                    CustomAttribute.of("rel", "stylesheet")))
    );

    public HtmlHeadComponent() {
        this(() -> Collections.emptyList(), () -> DEFAULT_COMPONENTS);
    }

    public HtmlHeadComponent(Supplier<List<ComponentAttribute>> componentAttributes, Supplier<List<Component>> subComponents) {
        super(HEAD_TAG_NAME, componentAttributes, subComponents);
    }

}
