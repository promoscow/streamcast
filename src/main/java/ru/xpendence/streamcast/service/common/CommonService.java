package ru.xpendence.streamcast.service.common;

import com.querydsl.core.types.dsl.EntityPathBase;
import ru.xpendence.streamcast.domain.AbstractEntity;
import ru.xpendence.streamcast.dto.AbstractDto;
import ru.xpendence.streamcast.dto.mapper.EntityDtoMapper;
import ru.xpendence.streamcast.repository.RepositoryCustom;

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
        D extends AbstractDto,
        Q extends EntityPathBase<E>,
        M extends EntityDtoMapper<E, D>,
        R extends RepositoryCustom<E, Q, Long>> {

    Optional<D> save(D dto);

    List<D> saveAll(List<D> dtoList);

    Optional<D> update(D dto);

    Optional<D> get(Long id);

    List<D> getAll();

    Boolean deleteById(Long id);

    Boolean deleteAll();

    void validate(Long id);
}
