package ru.xpendence.streamcast.controller;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.streamcast.controller.common.AbstractController;
import ru.xpendence.streamcast.domain.User;
import ru.xpendence.streamcast.dto.UserDto;
import ru.xpendence.streamcast.service.impl.UserService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 28.09.18
 * Time: 23:16
 * e-mail: 2262288@gmail.com
 */
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<UserDto, UserService> {

    public UserController(UserService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Page<UserDto>> getAll(
            @QuerydslPredicate(root = User.class) Predicate predicate,
            Pageable pageable) {
        return super.getAll(predicate, pageable);
    }
}
