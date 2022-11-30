package com.jfwf.core.web.test;

import com.jfwf.core.document.container.JfwfTextContainer;
import com.jfwf.core.document.page.JfwfPage;
import com.jfwf.core.document.page.layout.impl.JfwfGridLayout;
import com.jfwf.core.document.page.layout.impl.JfwfSimpleLayout;
import com.jfwf.core.html.components.impl.attribute.CustomAttribute;
import com.jfwf.core.html.components.impl.attribute.IdAttribute;
import com.jfwf.core.html.components.impl.container.DefaultContainer;
import com.jfwf.core.html.components.impl.platform.HtmlBodyComponent;
import com.jfwf.core.html.components.impl.platform.HtmlDocumentComponent;
import com.jfwf.core.html.components.impl.text.HeaderComponent;
import com.jfwf.core.html.components.impl.text.ParagraphComponent;
import com.jfwf.core.spring.dispatcher.PageDispatcher;
import com.jfwf.core.utils.HttpServletUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("test")
public class TestController {

    private static int counter = 1;
    private final PageDispatcher pageDispatcher;

    public TestController(PageDispatcher pageDispatcher) {
        this.pageDispatcher = pageDispatcher;
    }

    @PostConstruct
    public void init() {
        JfwfPage testPageRoute = JfwfPage.getBuilder()
                .pageRoute("testPageRoute")
                .pageTittle("Test Page Route")
                .appendLayout(JfwfSimpleLayout.of(new JfwfTextContainer(jfwfContext -> "Test content")))
                .appendLayout(JfwfGridLayout.getBuilder()
                        .appendColumn(new JfwfTextContainer(jfwfContext -> "Test first row content"))
                        .appendColumn(new JfwfTextContainer(jfwfContext -> "Test second row content"))
                        .appendColumn(new JfwfTextContainer(jfwfContext -> "Test third row content"))
                        .build())
                .build();

        pageDispatcher.registerPage(testPageRoute);
    }

    @GetMapping("")
    public void getText(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HeaderComponent headerComponent = new HeaderComponent(
                () -> Optional.ofNullable(request.getParameter("text")).orElse("Test header"),
                () -> Arrays.asList(new IdAttribute("1"), new CustomAttribute("attr", "value")),
                1
        );
        ParagraphComponent paragraphComponent = new ParagraphComponent(
                () -> "Test paragraph" + " reloaded %d times".formatted(counter++),
                () -> Arrays.asList(new IdAttribute("2"), new CustomAttribute("attr", "value"))
        );
        DefaultContainer defaultContainer = new DefaultContainer(
                Collections::emptyList,
                () -> Arrays.asList(headerComponent, paragraphComponent)
        );
        HtmlDocumentComponent htmlDocumentComponent = new HtmlDocumentComponent(
                () -> new HtmlBodyComponent(
                        Collections::emptyList,
                        () -> List.of(defaultContainer))
        );
        HttpServletUtils.putInputStreamToSuccessfulResponse(
                response, MediaType.TEXT_HTML_VALUE, IOUtils.toInputStream(htmlDocumentComponent.render())
        );
    }

}
