package com.jfwf.core.web.resource;

import com.jfwf.core.document.page.JfwfPage;
import com.jfwf.core.spring.dispatcher.PageDispatcher;
import com.jfwf.core.spring.renderer.PageRendere;
import com.jfwf.core.spring.resources.configuration.JfwfContext;
import com.jfwf.core.utils.HttpServletUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/p")
public class PageController {

    public final PageDispatcher pageDispatcher;

    public final PageRendere pageRendere;

    private final JfwfContext jfwfContext;

    public PageController(PageDispatcher pageDispatcher, PageRendere pageRendere, JfwfContext jfwfContext) {
        this.pageDispatcher = pageDispatcher;
        this.pageRendere = pageRendere;
        this.jfwfContext = jfwfContext;
    }

    @Async
    @GetMapping("{pageRoute}")
    public void pageByRoute(@PathVariable String pageRoute, HttpServletResponse httpServletResponse) throws IOException {
        JfwfPage pageFromRoute = pageDispatcher.getPageFromRoute(pageRoute);
        if (pageFromRoute == null) {
            HttpServletUtils.putExceptionToResponse(httpServletResponse, new RuntimeException("No page found for route \"%s\"".formatted(pageRoute)));
        }
        HttpServletUtils.putInputStreamToSuccessfulResponse(httpServletResponse, MediaType.TEXT_HTML_VALUE, pageRendere.render(pageFromRoute, jfwfContext));
    }

    @GetMapping("/welcome")
    public void welcomePage(HttpServletResponse httpServletResponse) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("web/welcome.html");
        long length = classPathResource.getFile().length();
        httpServletResponse.setContentLength((int) length);
        httpServletResponse.setContentType(MediaType.TEXT_HTML_VALUE);
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        IOUtils.copy(classPathResource.getInputStream(), httpServletResponse.getOutputStream());
    }

}
