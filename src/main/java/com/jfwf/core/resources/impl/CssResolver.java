package com.jfwf.core.resources.impl;

import com.jfwf.core.utils.HttpServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Order(1)
@Component(value = "defaultCssResolver")
public class CssResolver extends AbstractResourceResolverImpl {

    private static final String cssRequestPattern = ".*\\.css$";

    private static final String cssMediaType = "text/css";

    @Override
    public boolean isSuitable(HttpServletRequest request) {
        return HttpServletUtils.requestPathMatches(request, cssRequestPattern);
    }

    @Override
    public ResourceContext defineContext(HttpServletRequest request) {
        String requestPath = HttpServletUtils.getRequestPath(request);
        String cssPath = StringUtils.removeStartIgnoreCase(requestPath, "/");
        return new ResourceContext(cssPath, ResourceType.ClassPathResource, cssMediaType);
    }

}
