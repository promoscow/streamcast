package ru.xpendence.streamcast.service.impl;

import org.springframework.stereotype.Service;
import ru.xpendence.streamcast.domain.Message;
import ru.xpendence.streamcast.domain.QMessage;
import ru.xpendence.streamcast.dto.MessageDto;
import ru.xpendence.streamcast.dto.mapper.EntityDtoMapper;
import ru.xpendence.streamcast.repository.MessageRepository;
import ru.xpendence.streamcast.service.common.AbstractService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 28.09.18
 * Time: 22:14
 * e-mail: 2262288@gmail.com
 */
@Service
public class MessageService extends AbstractService<Message, MessageDto, QMessage,
        EntityDtoMapper<Message, MessageDto>, MessageRepository> {

    public MessageService(MessageRepository repository, EntityDtoMapper<Message, MessageDto> mapper) {
        super(repository, mapper);
    }
}
