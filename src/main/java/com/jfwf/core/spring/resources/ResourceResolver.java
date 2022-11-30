package com.jfwf.core.spring.resources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ResourceResolver {

    ResourceResolverResult resolve(HttpServletRequest request, HttpServletResponse response);

}
