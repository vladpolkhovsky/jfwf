package com.jfwf.core.spring.resources;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResourceResolverResult {

    private boolean resolved = false;

}
