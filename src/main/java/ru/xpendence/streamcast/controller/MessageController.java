package ru.xpendence.streamcast.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.streamcast.controller.common.AbstractController;
import ru.xpendence.streamcast.dto.MessageDto;
import ru.xpendence.streamcast.service.impl.MessageService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 30.09.18
 * Time: 19:38
 * e-mail: 2262288@gmail.com
 */
@RestController
@RequestMapping("/message")
public class MessageController extends AbstractController<MessageDto, MessageService> {

    protected MessageController(MessageService service) {
        super(service);
    }
}
