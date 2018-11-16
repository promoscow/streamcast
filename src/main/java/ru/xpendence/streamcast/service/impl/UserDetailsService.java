package ru.xpendence.streamcast.service.impl;

import org.springframework.stereotype.Service;
import ru.xpendence.streamcast.domain.QUserDetails;
import ru.xpendence.streamcast.domain.UserDetails;
import ru.xpendence.streamcast.dto.UserDetailsDto;
import ru.xpendence.streamcast.dto.mapper.impl.UserDetailsMapper;
import ru.xpendence.streamcast.repository.UserDetailsRepository;
import ru.xpendence.streamcast.service.common.AbstractService;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 16.11.2018
 * Time: 11:45
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Service
public class UserDetailsService extends AbstractService<UserDetails, UserDetailsDto, QUserDetails, UserDetailsMapper,
        UserDetailsRepository> {

    public UserDetailsService(UserDetailsRepository repository, UserDetailsMapper mapper) {
        super(repository, mapper);
    }
}
