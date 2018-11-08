package ru.xpendence.streamcast.frontend.admin;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.beans.factory.annotation.Autowired;
import ru.xpendence.streamcast.dto.UserDto;
import ru.xpendence.streamcast.service.impl.UserService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 06.10.18
 * Time: 20:57
 * e-mail: 2262288@gmail.com
 */
@UIScope
@Route(value = "admin/users")
@Theme(value = Lumo.class)
public class NewsStreamView extends VerticalLayout {

    private final UserService userService;

    private Grid<UserDto> grid = new Grid<>(UserDto.class);

    @Autowired
    public NewsStreamView(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    private void init() {
        List<UserDto> users = userService.getAll();
        grid.setItems(users);
    }
}
