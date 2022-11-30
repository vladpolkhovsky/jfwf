package com.jfwf.core.spring.resources.impl;

import com.jfwf.core.utils.HttpServletUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Order(0)
@Component(value = "defaultFaviconResolver")
public class FaviconResolver extends AbstractResourceResolverImpl {

    private static final String icoExtension = ".ico";
    private static final String xIcon = "image/x-icon";
    private static final String faviconRequestPattern = "(.*\\/)?favicon(\\.ico)?$";

    @Override
    public boolean isSuitable(HttpServletRequest request) {
        return HttpServletUtils.requestPathMatches(request, faviconRequestPattern);
    }

    @Override
    public ResourceContext defineContext(HttpServletRequest request) {
        String requestPath = HttpServletUtils.getRequestPath(request);
        String iconPath = StringUtils.appendIfMissing(
                StringUtils.removeStartIgnoreCase(requestPath, "/"),
                icoExtension
        );
        return new ResourceContext(iconPath, ResourceType.ClassPathResource, xIcon);
    }

}
