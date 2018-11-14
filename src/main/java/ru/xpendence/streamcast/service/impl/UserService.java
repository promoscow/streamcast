package ru.xpendence.streamcast.service.impl;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.xpendence.streamcast.domain.QUser;
import ru.xpendence.streamcast.domain.User;
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
//@Definition(entity = User.class, repository = UserRepository.class, mapper = UserMapper.class)
public class UserService extends AbstractService<User, UserDto, QUser,
        EntityDtoMapper<User, UserDto>, UserRepository> {

    public UserService(UserRepository repository, EntityDtoMapper<User, UserDto> mapper) {
        super(repository, mapper);
    }

    @Override
    public Page<UserDto> getAll(Predicate predicate, Pageable pageable) {
        Page<User> users = repository.getAll(predicate, pageable);
        return mapper.convertToDtoPage(users, pageable, users.getTotalElements());
    }
}

