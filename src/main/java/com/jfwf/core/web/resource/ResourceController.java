package com.jfwf.core.web.resource;

import com.jfwf.core.resources.ResourceResolver;
import com.jfwf.core.resources.ResourceResolverManager;
import com.jfwf.core.resources.ResourceResolverResult;
import com.jfwf.core.utils.HttpServletUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ResourceController {

    private final ResourceResolverManager resourceResolverManager;

    @GetMapping("/web/**")
    public void getResource(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        for (ResourceResolver resourceResolver : resourceResolverManager.getResourceResolverList()) {
            ResourceResolverResult resolverResult = resourceResolver.resolve(httpServletRequest, httpServletResponse);
            if (Optional.ofNullable(resolverResult).map(ResourceResolverResult::isResolved).orElse(false)) {
                return;
            }
        }
        HttpServletUtils.putExceptionToResponse(
                httpServletResponse,
                new IOException("Cannot resolve request: " + HttpServletUtils.getRequestPath(httpServletRequest))
        );
    }

}
