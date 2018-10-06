package ru.xpendence.streamcast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.streamcast.controller.common.AbstractController;
import ru.xpendence.streamcast.domain.QTopic;
import ru.xpendence.streamcast.domain.Topic;
import ru.xpendence.streamcast.dto.TopicDto;
import ru.xpendence.streamcast.dto.mapper.EntityDtoMapper;
import ru.xpendence.streamcast.repository.TopicRepository;
import ru.xpendence.streamcast.service.TopicService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 30.09.18
 * Time: 19:34
 * e-mail: 2262288@gmail.com
 */
@RestController
@RequestMapping("/topic")
public class TopicController extends AbstractController<Topic, TopicDto, QTopic,
        EntityDtoMapper<Topic, TopicDto>, TopicRepository, TopicService> {

    private TopicController(TopicService service) {
        super(service);
    }
}
