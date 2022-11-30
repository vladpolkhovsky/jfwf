package com.jfwf.core.document.container;

import com.jfwf.core.document.Renderable;
import com.jfwf.core.document.type.JfwfTextContainerType;
import com.jfwf.core.html.components.Component;
import com.jfwf.core.html.components.impl.text.ParagraphComponent;
import com.jfwf.core.spring.resources.configuration.JfwfContext;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class JfwfTextContainer implements JfwfContainer<String>, Renderable {

    private JfwfTextContainerType jfwfTextContainerType = JfwfTextContainerType.getDefault();

    private Function<JfwfContext, String> contextResolver = (context) -> "";

    public JfwfTextContainer() {

    }

    public JfwfTextContainer(Function<JfwfContext, String> contextResolver) {
        Objects.requireNonNull(contextResolver);
        this.contextResolver = contextResolver;
    }

    public JfwfTextContainer(JfwfTextContainerType jfwfTextContainerType, Function<JfwfContext, String> contextResolver) {
        this(contextResolver);
        Objects.requireNonNull(jfwfTextContainerType);
        this.contextResolver = contextResolver;
    }

    public static JfwfTextContainer of(Function<JfwfContext, String> contextResolver) {
        return new JfwfTextContainer(contextResolver);
    }

    public static JfwfTextContainer of(JfwfTextContainerType jfwfTextContainerType, Function<JfwfContext, String> contextResolver) {
        return new JfwfTextContainer(jfwfTextContainerType, contextResolver);
    }

    public void setType(JfwfTextContainerType jfwfTextContainerType) {
        Objects.requireNonNull(jfwfTextContainerType);
        this.jfwfTextContainerType = jfwfTextContainerType;
    }

    public void setContextResolver(Function<JfwfContext, String> contextResolver) {
        Objects.requireNonNull(contextResolver);
        this.contextResolver = contextResolver;
    }

    public JfwfTextContainerType getJfwfTextContainerType() {
        return jfwfTextContainerType;
    }

    public Function<JfwfContext, String> getContextResolver() {
        return contextResolver;
    }

    @Override
    public String contextResolver(JfwfContext context) {
        return contextResolver.apply(context);
    }

    //Переписать в отдельный класс.
    @Override
    public List<Component> renderedComponent(JfwfContext context) {
        return List.of(new ParagraphComponent(() -> contextResolver.apply(context), () -> List.of()));
    }

}
