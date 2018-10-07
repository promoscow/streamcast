package ru.xpendence.streamcast.service.common;

import org.springframework.transaction.annotation.Transactional;
import ru.xpendence.streamcast.domain.AbstractEntity;
import ru.xpendence.streamcast.dto.AbstractDto;

import java.util.List;
import java.util.Optional;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 09.09.18
 * Time: 22:38
 * e-mail: 2262288@gmail.com
 */
public interface CommonService<
        E extends AbstractEntity,
        D extends AbstractDto> {

    @Transactional
    Optional<D> save(D dto);

    @Transactional
    List<D> saveAll(List<D> dtoList);

    @Transactional
    Optional<D> update(D dto);

    @Transactional
    D get(Long id);

    @Transactional
    List<D> getAll();

    Boolean deleteById(Long id);

    Boolean deleteAll();

    void validate(Long id);
}
