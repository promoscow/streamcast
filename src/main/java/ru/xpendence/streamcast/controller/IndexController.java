package ru.xpendence.streamcast.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.xpendence.streamcast.domain.QMessage;
import ru.xpendence.streamcast.dto.MessageDto;
import ru.xpendence.streamcast.dto.transfer.View;
import ru.xpendence.streamcast.service.impl.MessageService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 16.11.2018
 * Time: 15:45
 * e-mail: 2262288@gmail.com
 */
@Controller
@RequestMapping("/")
public class IndexController {

    private final MessageService messageService;

    @Autowired
    public IndexController(MessageService messageService) {
        this.messageService = messageService;
    }

    @JsonView(value = View.Exists.class)
    @GetMapping(value = "/{hashcode}")
    public ResponseEntity<Page<MessageDto>> getByUserHashcode(@PathVariable("hashcode") String hashcode,
                                                              Pageable pageable) {
        BooleanExpression expression = QMessage.message.topic.hashcode.eq(hashcode);
        return ResponseEntity.ok(messageService.getAll(expression, pageable));
    }
}
