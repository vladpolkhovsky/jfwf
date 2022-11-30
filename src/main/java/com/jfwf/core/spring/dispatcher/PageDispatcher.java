package com.jfwf.core.spring.dispatcher;

import com.jfwf.core.document.page.JfwfPage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PageDispatcher {

    private final Map<String, JfwfPage> routeToPage = new HashMap<>();

    public void registerPage(JfwfPage jfwfPage) {
        routeToPage.put(jfwfPage.getPageRoute(), jfwfPage);
    }

    public JfwfPage getPageFromRoute(String pageRoute) {
        return routeToPage.get(pageRoute);
    }

}
