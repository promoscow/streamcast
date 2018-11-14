package ru.xpendence.streamcast.service.impl;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.xpendence.streamcast.domain.Message;
import ru.xpendence.streamcast.domain.QMessage;
import ru.xpendence.streamcast.dto.MessageDto;
import ru.xpendence.streamcast.dto.mapper.impl.MessageMapper;
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
        MessageMapper, MessageRepository> {

    public MessageService(MessageRepository repository, MessageMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Page<MessageDto> getAll(Predicate predicate, Pageable pageable) {
        return new PageImpl<>(mapper.convertToDtoList(repository.getAll(predicate, pageable)));
    }
}
