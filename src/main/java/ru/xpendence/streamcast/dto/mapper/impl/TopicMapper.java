package ru.xpendence.streamcast.dto.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.xpendence.streamcast.domain.QMessage;
import ru.xpendence.streamcast.domain.QUser;
import ru.xpendence.streamcast.domain.Topic;
import ru.xpendence.streamcast.dto.TopicDto;
import ru.xpendence.streamcast.dto.mapper.AbstractDtoMapper;
import ru.xpendence.streamcast.dto.mapper.Mapper;
import ru.xpendence.streamcast.repository.MessageRepository;
import ru.xpendence.streamcast.repository.UserRepository;

import javax.annotation.PostConstruct;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 28.09.18
 * Time: 22:16
 * e-mail: 2262288@gmail.com
 */
@Component
@Mapper(entity = Topic.class, dto = TopicDto.class)
public class TopicMapper extends AbstractDtoMapper<Topic, TopicDto> {

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    @Autowired
    public TopicMapper(UserRepository userRepository,
                       MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Topic.class, TopicDto.class)
                .addMappings(m -> {
                    m.skip(TopicDto::setAuthor);
                    m.skip(TopicDto::setSubscribers);
                    m.skip(TopicDto::setMessages);
                    m.skip(TopicDto::setErrorMessage);
                }).setPostConverter(toDtoConverter());
        mapper.createTypeMap(TopicDto.class, Topic.class)
                .addMappings(m -> {
                    m.skip(Topic::setAuthor);
                    m.skip(Topic::setSubscribers);
                    m.skip(Topic::setMessages);
                }).setPostConverter(toEntityConverter());
    }

    @Override
    protected void toDtoConverterImpl(Topic source, TopicDto destination) {
        destination.setAuthor(toId(source.getAuthor()));
        destination.setSubscribers(toIdList(source.getSubscribers()));
        destination.setMessages(toIdList(source.getMessages()));
    }

    @Override
    protected void toEntityConverterImpl(TopicDto source, Topic destination) {
        whenNotNull(source.getAuthor(), author -> destination.setAuthor(userRepository.getOne(author)));
        whenNotNull(source.getSubscribers(), subscribers
                -> destination.setSubscribers(toEntityList(userRepository.findAll(QUser.user.id.in(subscribers)))));
        whenNotNull(source.getMessages(), messages
                -> destination.setMessages(toEntityList(messageRepository.findAll(QMessage.message.id.in(messages)))));
    }
}
