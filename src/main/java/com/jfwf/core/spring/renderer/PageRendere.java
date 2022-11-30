package com.jfwf.core.spring.renderer;

import com.jfwf.core.document.page.JfwfPage;
import com.jfwf.core.html.components.Component;
import com.jfwf.core.spring.resources.configuration.JfwfContext;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Collectors;

@Service
public class PageRendere {

    public InputStream render(JfwfPage jfwfPage, JfwfContext context) {
        return new ByteArrayInputStream(jfwfPage.renderedComponent(context).stream()
                .map(Component::render)
                .collect(Collectors.joining())
                .getBytes()
        );
    }

}
