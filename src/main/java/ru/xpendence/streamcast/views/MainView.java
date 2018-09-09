package ru.xpendence.streamcast.views;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 09.09.18
 * Time: 10:20
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Route(value = "")
@Theme(value = Lumo.class)
public class MainView extends VerticalLayout {

    public MainView() {

        Label label = new Label("Hi!");
        add(label);


    }
}
