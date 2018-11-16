package ru.xpendence.streamcast.controller;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.streamcast.controller.common.AbstractController;
import ru.xpendence.streamcast.domain.Message;
import ru.xpendence.streamcast.domain.QMessage;
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

    @Override
    public ResponseEntity<Page<MessageDto>> getAll(
            @QuerydslPredicate(root = Message.class) Predicate predicate,
            Pageable pageable) {
        return super.getAll(predicate, pageable);
    }

    public MessageController(MessageService service) {
        super(service);
    }

    @GetMapping(value = "/{hashcode}")
    public ResponseEntity<Page<MessageDto>> getByUserHashcode(@PathVariable("hashcode") String hashcode, Pageable pageable) {
        return ResponseEntity.ok(service.getAll(QMessage.message.topic.author.hashcode.eq(hashcode), pageable));
    }
}
