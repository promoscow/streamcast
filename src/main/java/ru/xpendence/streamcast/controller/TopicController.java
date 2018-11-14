package ru.xpendence.streamcast.controller;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.streamcast.controller.common.AbstractController;
import ru.xpendence.streamcast.domain.Topic;
import ru.xpendence.streamcast.dto.TopicDto;
import ru.xpendence.streamcast.service.impl.TopicService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 30.09.18
 * Time: 19:34
 * e-mail: 2262288@gmail.com
 */
@RestController
@RequestMapping("/topic")
public class TopicController extends AbstractController<TopicDto, TopicService> {

    public TopicController(TopicService service) {
        super(service);
    }

    @Override
    public ResponseEntity<Page<TopicDto>> getAll(
            @QuerydslPredicate(root = Topic.class) Predicate predicate,
            Pageable pageable) {
        return super.getAll(predicate, pageable);
    }
}
