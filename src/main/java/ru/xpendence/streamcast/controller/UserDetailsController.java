package ru.xpendence.streamcast.controller;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.xpendence.streamcast.controller.common.AbstractController;
import ru.xpendence.streamcast.dto.UserDetailsDto;
import ru.xpendence.streamcast.service.impl.UserDetailsService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 16.11.2018
 * Time: 13:23
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Controller
@RequestMapping("/user/details")
public class UserDetailsController extends AbstractController<UserDetailsDto, UserDetailsService> {

    protected UserDetailsController(UserDetailsService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Page<UserDetailsDto>> getAll(
            @QuerydslPredicate(root = UserDetailsDto.class) Predicate predicate,
            Pageable pageable) {
        return super.getAll(predicate, pageable);
    }
}
