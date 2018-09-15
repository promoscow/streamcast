package ru.xpendence.streamcast.dto.mapper.impl;

import org.springframework.stereotype.Component;
import ru.xpendence.streamcast.domain.User;
import ru.xpendence.streamcast.dto.UserDto;
import ru.xpendence.streamcast.dto.mapper.AbstractDtoMapper;
import ru.xpendence.streamcast.dto.mapper.Mapper;

import javax.annotation.PostConstruct;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 11.09.18
 * Time: 9:32
 * e-mail: 2262288@gmail.com
 */
@Component
@Mapper(entity = User.class, dto = UserDto.class)
public class UserMapper extends AbstractDtoMapper<User, UserDto> {

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(User.class, UserDto.class)
                .addMappings(mapping -> {
                    mapping.skip(UserDto::setAuthors);
                    mapping.skip(UserDto::setSubscribers);
                    mapping.skip(UserDto::setMessagesPosted);
                    mapping.skip(UserDto::setTopicsCreated);
                    mapping.skip(UserDto::setTopicsSubscribed);
                }).setPostConverter(toDtoConverter());
        mapper.createTypeMap(UserDto.class, User.class)
                .addMappings(mapping -> {
                    mapping.skip(User::setSubscribers);
                    mapping.skip(User::setMessagesPosted);
                    mapping.skip(User::setTopicsCreated);
                    mapping.skip(User::setTopicsSubscribed);
                    mapping.skip(User::setAuthors);
                }).setPostConverter(toEntityConverter());
    }

    @Override
    protected void toDtoConverterImpl(User source, UserDto destination) {
        super.toDtoConverterImpl(source, destination);
    }

    @Override
    protected void toEntityConverterImpl(UserDto source, User destination) {
        super.toEntityConverterImpl(source, destination);
    }
}
