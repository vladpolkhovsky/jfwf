package com.jfwf.core.document.page.builder;

import com.jfwf.core.document.page.JfwfPage;
import com.jfwf.core.document.page.layout.JfwfPageLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class JfwfPageBuilder {

    private final List<JfwfPageLayout> pageLayouts = new ArrayList<>();

    private String pageTittle = "";

    private String pageRoute = "";

    public JfwfPageBuilder() {

    }

    public JfwfPageBuilder pageTittle(String pageTittle) {
        Objects.requireNonNull(pageTittle);
        this.pageTittle = pageTittle;
        return this;
    }

    public JfwfPageBuilder pageRoute(String pageRoute) {
        Objects.requireNonNull(pageRoute);
        this.pageRoute = pageRoute;
        return this;
    }

    public JfwfPageBuilder appendLayout(JfwfPageLayout jfwfPageLayout) {
        Objects.requireNonNull(jfwfPageLayout);
        pageLayouts.add(jfwfPageLayout);
        return this;
    }

    public JfwfPage build() {
        return new JfwfPage(pageTittle, pageRoute, pageLayouts);
    }

}
