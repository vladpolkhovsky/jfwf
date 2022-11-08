package com.jfwf.core.web.test;

import com.jfwf.core.components.impl.attribute.CustomAttribute;
import com.jfwf.core.components.impl.attribute.IdAttribute;
import com.jfwf.core.components.impl.container.DefaultContainer;
import com.jfwf.core.components.impl.platform.HtmlBodyComponent;
import com.jfwf.core.components.impl.platform.HtmlDocumentComponent;
import com.jfwf.core.components.impl.platform.HtmlHeadComponent;
import com.jfwf.core.components.impl.text.HeaderComponent;
import com.jfwf.core.components.impl.text.ParagraphComponent;
import com.jfwf.core.utils.HttpServletUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

@Controller
@RequestMapping("test")
public class TestController {

    private static int counter = 1;

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
                () -> new HtmlHeadComponent(
                        () -> Arrays.asList(CustomAttribute.of("lang", "en")),
                        Collections::emptyList),
                () -> new HtmlBodyComponent(
                        Collections::emptyList,
                        () -> Arrays.asList(defaultContainer))
        );
        HttpServletUtils.putInputStreamToSuccessfulResponse(
                response, MediaType.TEXT_HTML_VALUE, IOUtils.toInputStream(htmlDocumentComponent.render())
        );
    }

}
