package ru.xpendence.streamcast.dto.mapper.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.xpendence.streamcast.attributes.ActiveType;
import ru.xpendence.streamcast.domain.QTopic;
import ru.xpendence.streamcast.domain.QUser;
import ru.xpendence.streamcast.domain.User;
import ru.xpendence.streamcast.dto.UserDto;
import ru.xpendence.streamcast.dto.mapper.AbstractDtoMapper;
import ru.xpendence.streamcast.dto.mapper.Mapper;
import ru.xpendence.streamcast.repository.TopicRepository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 11.09.18
 * Time: 9:32
 * e-mail: 2262288@gmail.com
 */
@Component
@Mapper(entity = User.class, dto = UserDto.class)
public class UserMapper extends AbstractDtoMapper<User, UserDto> {

    private final TopicRepository topicRepository;

    @Autowired
    public UserMapper(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    private QUser qUser = QUser.user;

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(User.class, UserDto.class)
                .addMappings(m -> {
                    m.skip(UserDto::setActive);
                    m.skip(UserDto::setAuthors);
                    m.skip(UserDto::setSubscribers);
                    m.skip(UserDto::setTopicsCreated);
                    m.skip(UserDto::setTopicsSubscribed);
                    m.skip(UserDto::setErrorMessage);
                }).setPostConverter(toDtoConverter());
        mapper.createTypeMap(UserDto.class, User.class)
                .addMappings(m -> {
                    m.skip(User::setActive);
                    m.skip(User::setSubscribers);
                    m.skip(User::setTopicsCreated);
                    m.skip(User::setTopicsSubscribed);
                    m.skip(User::setAuthors);
                }).setPostConverter(toEntityConverter());
    }

    @Override
    protected void toDtoConverterImpl(User source, UserDto destination) {
        whenNotNull(source.getAuthors(), authors -> destination.setAuthors(toIdList(authors)));
        whenNotNull(source.getSubscribers(), subscribers -> destination.setSubscribers(toIdList(subscribers)));
        whenNotNull(source.getTopicsCreated(), topics -> destination.setTopicsCreated(toIdList(topics)));
        whenNotNull(source.getTopicsSubscribed(), topics -> destination.setTopicsSubscribed(toIdList(topics)));
        destination.setActive(source.getActive().getId());
    }

    @Override
    protected void toEntityConverterImpl(UserDto source, User destination) {
        whenNotNull(source.getAuthors(), authors
                -> destination.setAuthors(
                new JPAQueryFactory(entityManager)
                        .selectFrom(qUser)
                        .innerJoin(qUser.authors, qUser)
                        .on(qUser.id.in(authors))
                        .fetch()));
        whenNotNull(source.getSubscribers(), subscribers
                -> destination.setSubscribers(
                new JPAQueryFactory(entityManager)
                        .selectFrom(qUser)
                        .innerJoin(qUser.subscribers, qUser)
                        .on(qUser.id.in(subscribers))
                        .fetch()
        ));
        whenNotNull(source.getTopicsCreated(), topics
                -> destination.setTopicsCreated(toEntityList(topicRepository.findAll(QTopic.topic.id.in(topics)))));
        whenNotNull(source.getTopicsSubscribed(), topics
                -> destination.setTopicsSubscribed(toEntityList(topicRepository.findAll(QTopic.topic.id.in(topics)))));
        whenNotNull(source.getActive(), activeType
                -> destination.setActive(ActiveType.valueOf(source.getActive())));
    }
}
