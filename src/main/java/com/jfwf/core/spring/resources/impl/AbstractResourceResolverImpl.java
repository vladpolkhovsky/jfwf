package com.jfwf.core.spring.resources.impl;

import com.jfwf.core.spring.resources.ResourceResolver;
import com.jfwf.core.spring.resources.ResourceResolverResult;
import com.jfwf.core.utils.HttpServletUtils;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractResourceResolverImpl implements ResourceResolver {

    private static ResourceResolverResult getResult(boolean isResolved) {
        return ResourceResolverResult.builder()
                .resolved(isResolved)
                .build();
    }

    public abstract boolean isSuitable(HttpServletRequest request);

    public abstract ResourceContext defineContext(HttpServletRequest request);

    @Override
    public ResourceResolverResult resolve(HttpServletRequest request, HttpServletResponse response) {
        if (isSuitable(request)) {
            ResourceContext resourceContext = defineContext(request);
            ResourceResolverResult result;
            switch (resourceContext.resourceType) {
                case ClassPathResource -> result = readClassPathResource(resourceContext, response);
                case FileSystemResource -> result = readFileSystemResource(resourceContext, response);
                case GeneratedResource -> result = readGeneratedResource(resourceContext, response);
                default ->
                        throw new RuntimeException("Cannot resolve resource " + HttpServletUtils.getRequestPath(request));
            }
            return result;
        }
        return getResult(false);
    }

    private ResourceResolverResult readGeneratedResource(ResourceContext resourceContext, HttpServletResponse response) {
        throw new RuntimeException("Cannot resolve resource " + resourceContext.resourcePath);
    }

    private ResourceResolverResult readFileSystemResource(ResourceContext resourceContext, HttpServletResponse response) {
        throw new RuntimeException("Cannot resolve resource " + resourceContext.resourcePath);
    }

    public ResourceResolverResult readClassPathResource(ResourceContext context, HttpServletResponse httpServletResponse) {
        ClassPathResource iconResource = new ClassPathResource(context.resourcePath);
        try {
            HttpServletUtils.putInputStreamToSuccessfulResponse(
                    httpServletResponse,
                    context.mediaType,
                    iconResource.getInputStream()
            );
            return getResult(true);
        } catch (IOException e) {
            try {
                HttpServletUtils.putExceptionToResponse(httpServletResponse, e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        return getResult(false);
    }

    public enum ResourceType {
        ClassPathResource,
        FileSystemResource,
        GeneratedResource
    }

    public record ResourceContext(String resourcePath, ResourceType resourceType, String mediaType) {

    }

}
