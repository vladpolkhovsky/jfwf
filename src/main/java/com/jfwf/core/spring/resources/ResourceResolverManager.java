package com.jfwf.core.spring.resources;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "resourceResolverManager")
@AllArgsConstructor
public class ResourceResolverManager {

    private final List<ResourceResolver> resourceResolverList;

    public List<ResourceResolver> getResourceResolverList() {
        return resourceResolverList;
    }

}
