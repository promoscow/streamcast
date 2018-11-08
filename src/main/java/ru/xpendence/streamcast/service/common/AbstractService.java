package ru.xpendence.streamcast.service.common;

import com.querydsl.core.types.dsl.EntityPathBase;
import org.springframework.beans.factory.annotation.Autowired;
import ru.xpendence.streamcast.attributes.ErrorType;
import ru.xpendence.streamcast.domain.AbstractEntity;
import ru.xpendence.streamcast.dto.AbstractDto;
import ru.xpendence.streamcast.dto.mapper.EntityDtoMapper;
import ru.xpendence.streamcast.exception.DatabaseException;
import ru.xpendence.streamcast.repository.RepositoryCustom;

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
        R extends RepositoryCustom<E, Q, Long>> implements CommonService<D> {

    private final R repository;
    private final M mapper;

    @Autowired
    public AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<D> save(D dto) {
        return Optional.of(mapper.convertToDto(repository.save(mapper.convertToEntity(dto))));
    }

    @Override
    public List<D> saveAll(List<D> dtoList) {
        return mapper.convertToDtoList(repository.saveAll(mapper.convertToEntityList(dtoList)));
    }

    @Override
    public Optional<D> update(D dto) {
        return Optional.of(mapper.convertToDto(repository.save(mapper.convertToEntity(dto))));
    }

    @Override
    public D get(Long id) {
        return repository.findById(id).map(mapper::convertToDto)
                .orElseThrow(() -> new DatabaseException(ErrorType.ENTITY_NOT_FOUND.getDescription(), id));
    }

    @Override
    public List<D> getAll() {
        return mapper.convertToDtoList(repository.findAll());
    }

    @Override
    public Boolean deleteById(Long id) {
        repository.deleteById(id);
        return !repository.findById(id).isPresent();
    }

    @Override
    public Boolean deleteAll() {
        repository.deleteAll();
        return repository.findAll().isEmpty();
    }

    @Override
    public void validate(Long id) {
    }
}
