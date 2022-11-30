package com.jfwf.core.spring.resources.impl;

import com.jfwf.core.utils.HttpServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Order(2)
@Component(value = "defaultJsResolver")
public class JsResolver extends AbstractResourceResolverImpl {

    private static final String jsRequestPattern = ".*\\.js$";

    private static final String jsMediaType = "text/js";

    @Override
    public boolean isSuitable(HttpServletRequest request) {
        return HttpServletUtils.requestPathMatches(request, jsRequestPattern);
    }

    @Override
    public ResourceContext defineContext(HttpServletRequest request) {
        String requestPath = HttpServletUtils.getRequestPath(request);
        String cssPath = StringUtils.removeStartIgnoreCase(requestPath, "/");
        return new ResourceContext(cssPath, ResourceType.ClassPathResource, jsMediaType);
    }

}
