package ru.xpendence.streamcast.frontend;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 09.09.18
 * Time: 10:20
 * e-mail: 2262288@gmail.com
 */
@Route(value = "")
@Theme(value = Lumo.class)
public class MainView extends VerticalLayout {

    public MainView() {

        Label timestamp = new Label(
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss, dd MMM yyyy"))
        );
        Label hello = new Label("Streamcast app. Instant news.");
        add(hello);
        add(timestamp);
    }
}
