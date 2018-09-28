package ru.xpendence.streamcast.dto.mapper.impl;

import org.springframework.stereotype.Component;
import ru.xpendence.streamcast.domain.Topic;
import ru.xpendence.streamcast.dto.TopicDto;
import ru.xpendence.streamcast.dto.mapper.AbstractDtoMapper;
import ru.xpendence.streamcast.dto.mapper.Mapper;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 28.09.18
 * Time: 22:16
 * e-mail: 2262288@gmail.com
 */
@Component
@Mapper(entity = Topic.class, dto = TopicDto.class)
public class TopicMapper extends AbstractDtoMapper<Topic, TopicDto> {
}
