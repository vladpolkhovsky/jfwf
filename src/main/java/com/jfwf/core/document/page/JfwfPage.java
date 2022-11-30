package com.jfwf.core.document.page;

import com.jfwf.core.document.page.builder.JfwfPageBuilder;
import com.jfwf.core.document.page.layout.JfwfPageLayout;

import java.util.List;

public class JfwfPage {

    private final String pageRoute;

    private final String pageTittle;

    private final List<JfwfPageLayout> pageLayouts;

    public JfwfPage(String pageTittle, String pageRoute, List<JfwfPageLayout> pageLayouts) {
        this.pageTittle = pageTittle;
        this.pageRoute = pageRoute;
        this.pageLayouts = pageLayouts;
    }

    public static JfwfPageBuilder getBuilder() {
        return new JfwfPageBuilder();
    }

    public static JfwfPage getDefault() {
        return new JfwfPageBuilder().build();
    }

}
