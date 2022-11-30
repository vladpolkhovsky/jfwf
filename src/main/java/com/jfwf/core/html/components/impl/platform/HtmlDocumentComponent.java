package com.jfwf.core.html.components.impl.platform;

import com.jfwf.core.html.components.Component;
import com.jfwf.core.html.components.impl.container.AbstractContainerComponent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public final class HtmlDocumentComponent extends AbstractContainerComponent {

    private static final String HTML_TAG_NAME = "html";

    private static final String SIMPLE_HTML_PAGE_TEMPLATE = """
            <!doctype html>
                        
            """;

    public HtmlDocumentComponent(Supplier<HtmlHeadComponent> headerComponentSupplier, Supplier<HtmlBodyComponent> htmlBodyComponentSupplier) {
        super(HTML_TAG_NAME,
                Collections::emptyList,
                () -> {
                    Component headerComponent = headerComponentSupplier.get();
                    Component bodyComponent = htmlBodyComponentSupplier.get();
                    return Arrays.asList(headerComponent, bodyComponent);
                });
    }

    public HtmlDocumentComponent(Supplier<HtmlBodyComponent> htmlBodyComponentSupplier) {
        super(HTML_TAG_NAME,
                Collections::emptyList,
                () -> List.of(new HtmlHeadComponent(), htmlBodyComponentSupplier.get()));
    }

    @Override
    public String render() {
        return SIMPLE_HTML_PAGE_TEMPLATE.formatted() + super.render();
    }

}
