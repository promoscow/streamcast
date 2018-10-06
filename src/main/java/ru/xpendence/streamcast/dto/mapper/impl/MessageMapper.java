package ru.xpendence.streamcast.dto.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.xpendence.streamcast.domain.Message;
import ru.xpendence.streamcast.dto.MessageDto;
import ru.xpendence.streamcast.dto.mapper.AbstractDtoMapper;
import ru.xpendence.streamcast.dto.mapper.Mapper;
import ru.xpendence.streamcast.repository.TopicRepository;
import ru.xpendence.streamcast.repository.UserRepository;

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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Message.class, MessageDto.class)
                .addMappings(m -> {
                    m.skip(MessageDto::setAuthor);
                    m.skip(MessageDto::setTopic);
                    m.skip(MessageDto::setErrorMessage);
                }).setPostConverter(toDtoConverter());
        mapper.createTypeMap(MessageDto.class, Message.class)
                .addMappings(m -> {
                    m.skip(Message::setAuthor);
                    m.skip(Message::setTopic);
                }).setPostConverter(toEntityConverter());
    }

    @Override
    protected void toDtoConverterImpl(Message source, MessageDto destination) {
        destination.setAuthor(toId(source.getAuthor()));
        destination.setTopic(toId(source.getTopic()));
    }

    @Override
    protected void toEntityConverterImpl(MessageDto source, Message destination) {
        whenNotNull(source.getAuthor(), author -> destination.setAuthor(userRepository.getOne(author)));
        whenNotNull(source.getTopic(), topic -> destination.setTopic(topicRepository.getOne(topic)));
    }
}
