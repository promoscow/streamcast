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
