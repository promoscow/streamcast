package ru.xpendence.streamcast.service;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.xpendence.streamcast.domain.AbstractEntity;
import ru.xpendence.streamcast.dto.AbstractDto;
import ru.xpendence.streamcast.dto.mapper.EntityDtoMapper;
import ru.xpendence.streamcast.repository.RepositoryCustom;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 11.09.18
 * Time: 9:17
 * e-mail: 2262288@gmail.com
 */
public abstract class AbstractService<
        E extends AbstractEntity,
        D extends AbstractDto,
        Q extends EntityPathBase<E>,
        M extends EntityDtoMapper<E, D>,
        R extends RepositoryCustom<E, Q, Long>> implements CommonService<E, D, Q, M, R> {

    @Override
    public Optional<D> save(D dto) {
        return Optional.empty();
    }

    @Override
    public List<D> saveAll(List<D> entries) {
        return null;
    }

    @Override
    public Optional<D> update(D dto) {
        return Optional.empty();
    }

    @Override
    public Optional<D> get(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<D> getBetween(Long id, LocalDateTime from, LocalDateTime to, Pageable pageable) {
        return null;
    }

    @Override
    public Page<D> getAll(Predicate predicate, Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public E getEntity(Long id) {
        return null;
    }
}
