package ru.xpendence.streamcast.dto.mapper.impl;

import org.springframework.stereotype.Component;
import ru.xpendence.streamcast.domain.Message;
import ru.xpendence.streamcast.dto.MessageDto;
import ru.xpendence.streamcast.dto.mapper.AbstractDtoMapper;
import ru.xpendence.streamcast.dto.mapper.Mapper;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 28.09.18
 * Time: 22:17
 * e-mail: 2262288@gmail.com
 */
@Component
@Mapper(entity = Message.class, dto = MessageDto.class)
public class MessageMapper extends AbstractDtoMapper<Message, MessageDto> {
}
