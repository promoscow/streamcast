package ru.xpendence.streamcast.service;

import org.springframework.stereotype.Service;
import ru.xpendence.streamcast.domain.QUser;
import ru.xpendence.streamcast.domain.User;
import ru.xpendence.streamcast.domain.definition.Definition;
import ru.xpendence.streamcast.dto.UserDto;
import ru.xpendence.streamcast.dto.mapper.EntityDtoMapper;
import ru.xpendence.streamcast.repository.UserRepository;
import ru.xpendence.streamcast.service.common.AbstractService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 28.09.18
 * Time: 22:05
 * e-mail: 2262288@gmail.com
 */
@Service
@Definition(entity = User.class)
public class UserService extends AbstractService<User, UserDto, QUser,
        EntityDtoMapper<User, UserDto>, UserRepository> {

    public UserService(UserRepository repository, EntityDtoMapper<User, UserDto> mapper) {
        super(repository, mapper);
    }
}

