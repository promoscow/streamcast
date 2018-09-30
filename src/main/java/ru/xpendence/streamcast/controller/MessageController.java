package ru.xpendence.streamcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.xpendence.streamcast.controller.common.AbstractController;
import ru.xpendence.streamcast.domain.Message;
import ru.xpendence.streamcast.domain.QMessage;
import ru.xpendence.streamcast.dto.MessageDto;
import ru.xpendence.streamcast.dto.mapper.EntityDtoMapper;
import ru.xpendence.streamcast.repository.MessageRepository;
import ru.xpendence.streamcast.service.MessageService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 30.09.18
 * Time: 19:38
 * e-mail: 2262288@gmail.com
 */
@Controller
@RequestMapping("/message")
public class MessageController extends AbstractController<Message, MessageDto, QMessage,
        EntityDtoMapper<Message, MessageDto>, MessageRepository, MessageService> {

    protected MessageController(MessageService service) {
        super(service);
    }
}
