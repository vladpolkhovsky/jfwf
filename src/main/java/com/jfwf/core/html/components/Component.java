package com.jfwf.core.html.components;

import java.util.List;

public interface Component {

    List<Component> getSubComponents();

    String render();

}
