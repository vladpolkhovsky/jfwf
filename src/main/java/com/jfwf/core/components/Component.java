package com.jfwf.core.components;

import java.util.List;

public interface Component {

    List<Component> getSubComponents();

    String render();

}
