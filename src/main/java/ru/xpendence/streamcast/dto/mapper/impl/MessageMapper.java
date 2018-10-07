package ru.xpendence.streamcast.dto.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.xpendence.streamcast.attributes.ActiveType;
import ru.xpendence.streamcast.domain.Message;
import ru.xpendence.streamcast.dto.MessageDto;
import ru.xpendence.streamcast.dto.mapper.AbstractDtoMapper;
import ru.xpendence.streamcast.dto.mapper.Mapper;
import ru.xpendence.streamcast.repository.TopicRepository;

import javax.annotation.PostConstruct;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 28.09.18
 * Time: 22:17
 * e-mail: 2262288@gmail.com
 */
@Component
@Mapper(entity = Message.class, dto = MessageDto.class)
public class MessageMapper extends AbstractDtoMapper<Message, MessageDto> {

    private final TopicRepository topicRepository;

    @Autowired
    public MessageMapper(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Message.class, MessageDto.class)
                .addMappings(m -> {
                    m.skip(MessageDto::setTopic);
                    m.skip(MessageDto::setErrorMessage);
                    m.skip(MessageDto::setActive);
                }).setPostConverter(toDtoConverter());
        mapper.createTypeMap(MessageDto.class, Message.class)
                .addMappings(m -> {
                    m.skip(Message::setTopic);
                    m.skip(Message::setActive);
                }).setPostConverter(toEntityConverter());
    }

    @Override
    protected void toDtoConverterImpl(Message source, MessageDto destination) {
        destination.setTopic(toId(source.getTopic()));
        destination.setActive(source.getActive().getId());
    }

    @Override
    protected void toEntityConverterImpl(MessageDto source, Message destination) {
        whenNotNull(source.getTopic(), topic -> destination.setTopic(topicRepository.getOne(topic)));
        whenNotNull(source.getActive(), activeType -> destination.setActive(ActiveType.valueOf(source.getActive())));
    }
}
