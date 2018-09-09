package ru.xpendence.streamcast.service;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import ru.xpendence.streamcast.domain.AbstractEntity;
import ru.xpendence.streamcast.dto.AbstractDto;
import ru.xpendence.streamcast.dto.mapper.EntityDtoMapper;
import ru.xpendence.streamcast.repository.RepositoryCustom;

import java.time.LocalDateTime;
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

    @Transactional
    Optional<D> save(D dto);

    @Transactional
    List<D> saveAll(List<D> entries);

    Optional<D> update(D dto);

    @Transactional
    Optional<D> get(Long id);

    @Transactional
    Page<D> getBetween(Long id, LocalDateTime from, LocalDateTime to, Pageable pageable);

    @Transactional
    Page<D> getAll(Predicate predicate, Pageable pageable);

    @Transactional
    Boolean delete(Long id);

    @Transactional
    E getEntity(Long id);
}
