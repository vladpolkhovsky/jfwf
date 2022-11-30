package com.jfwf.core.document.page;

import com.jfwf.core.document.Renderable;
import com.jfwf.core.document.page.builder.JfwfPageBuilder;
import com.jfwf.core.document.page.layout.JfwfPageLayout;
import com.jfwf.core.html.components.Component;
import com.jfwf.core.html.components.impl.platform.HtmlBodyComponent;
import com.jfwf.core.html.components.impl.platform.HtmlDocumentComponent;
import com.jfwf.core.html.components.impl.platform.HtmlHeadComponent;
import com.jfwf.core.html.components.impl.text.AbstractTextComponent;
import com.jfwf.core.spring.resources.configuration.JfwfContext;
import org.apache.commons.collections4.ListUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JfwfPage implements Renderable {

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

    public String getPageRoute() {
        return pageRoute;
    }

    public String getPageTittle() {
        return pageTittle;
    }

    public List<JfwfPageLayout> getPageLayouts() {
        return pageLayouts;
    }

    //Вынести в отдельный класс....
    @Override
    public List<Component> renderedComponent(JfwfContext context) {

        HtmlHeadComponent htmlHeadComponent = new HtmlHeadComponent(() -> Collections.emptyList(), () -> ListUtils.union(
                HtmlHeadComponent.DEFAULT_COMPONENTS,
                List.of(new AbstractTextComponent(() -> pageTittle, () -> Collections.emptyList()) {
                    @Override
                    protected String tagName() {
                        return "title";
                    }
                })
        )
        );

        List<Component> subComponents = getPageLayouts().stream()
                .flatMap(jfwfPageLayout -> jfwfPageLayout.renderedComponent(context).stream())
                .collect(Collectors.toList());


        HtmlDocumentComponent htmlDocumentComponent = new HtmlDocumentComponent(
                () -> htmlHeadComponent,
                () -> new HtmlBodyComponent(() -> Collections.emptyList(), () -> subComponents)
        );

        return List.of(
                htmlDocumentComponent
        );
    }
}
