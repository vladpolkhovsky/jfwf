package page;

import com.jfwf.core.document.container.JfwfTextContainer;
import com.jfwf.core.document.page.JfwfPage;
import com.jfwf.core.document.page.layout.builder.JfwfGridLayoutBuilder;
import com.jfwf.core.document.page.layout.impl.JfwfSimpleLayout;

public class MainPage {

    public static void main(String[] args) {

        JfwfSimpleLayout<String> helloWorldLine = JfwfSimpleLayout.of(
                JfwfTextContainer.of(context -> "1")
        );

        JfwfPage page = JfwfPage.getBuilder()
                .pageTittle(null)
                .pageRoute(null)
                .appendLayout(helloWorldLine)
                .build();


        new JfwfGridLayoutBuilder()
                .appendColumn(JfwfTextContainer.of(context -> "1"));

    }

}
