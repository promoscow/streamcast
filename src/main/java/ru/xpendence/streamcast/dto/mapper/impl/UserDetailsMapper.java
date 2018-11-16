package ru.xpendence.streamcast.dto.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.xpendence.streamcast.attributes.VerificationStatus;
import ru.xpendence.streamcast.domain.UserDetails;
import ru.xpendence.streamcast.dto.UserDetailsDto;
import ru.xpendence.streamcast.dto.mapper.AbstractDtoMapper;
import ru.xpendence.streamcast.dto.mapper.Mapper;
import ru.xpendence.streamcast.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 16.11.2018
 * Time: 13:02
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Component
@Mapper(entity = UserDetails.class, dto = UserDetailsDto.class)
public class UserDetailsMapper extends AbstractDtoMapper<UserDetails, UserDetailsDto> {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(UserDetails.class, UserDetailsDto.class)
                .addMappings(m -> {
                    m.skip(UserDetailsDto::setUser);
                    m.skip(UserDetailsDto::setVerificationStatus);
                    m.skip(UserDetailsDto::setActive);
                }).setPostConverter(toDtoConverter());
        mapper.createTypeMap(UserDetailsDto.class, UserDetails.class)
                .addMappings(m -> {
                    m.skip(UserDetails::setUser);
                    m.skip(UserDetails::setVerificationStatus);
                }).setPostConverter(toEntityConverter());
    }

    @Override
    protected void toDtoConverterImpl(UserDetails source, UserDetailsDto destination) {
        whenNotNull(source.getUser(), user -> destination.setUser(toId(source.getUser())));
        whenNotNull(source.getVerificationStatus(), verificationStatus -> destination.setVerificationStatus(verificationStatus.name()));
    }

    @Override
    protected void toEntityConverterImpl(UserDetailsDto source, UserDetails destination) {
        whenNotNull(source.getUser(), user -> destination.setUser(userRepository.findById(user).orElse(null)));
        whenNotNull(source.getVerificationStatus(), status -> destination.setVerificationStatus(getStatus(status)));
    }

    private VerificationStatus getStatus(String status) {
        return Arrays.stream(VerificationStatus.values()).filter(s -> Objects.equals(s.name(), status)).findFirst()
                .orElse(VerificationStatus.NOT_VERIFIED);
    }
}
