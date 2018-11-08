package ru.xpendence.streamcast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.streamcast.controller.common.AbstractController;
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

    private TopicController(TopicService service) {
        super(service);
    }
}
