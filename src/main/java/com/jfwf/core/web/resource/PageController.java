package com.jfwf.core.web.resource;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/p")
public class PageController {

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
