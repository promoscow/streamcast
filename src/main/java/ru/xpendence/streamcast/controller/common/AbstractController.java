package ru.xpendence.streamcast.controller.common;

import com.querydsl.core.types.dsl.EntityPathBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import ru.xpendence.streamcast.attributes.ErrorType;
import ru.xpendence.streamcast.domain.AbstractEntity;
import ru.xpendence.streamcast.dto.AbstractDto;
import ru.xpendence.streamcast.dto.mapper.EntityDtoMapper;
import ru.xpendence.streamcast.exception.DatabaseException;
import ru.xpendence.streamcast.repository.RepositoryCustom;
import ru.xpendence.streamcast.service.common.CommonService;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 11:15
 * e-mail: 2262288@gmail.com
 */
public abstract class AbstractController<
        E extends AbstractEntity,
        D extends AbstractDto,
        Q extends EntityPathBase<E>,
        M extends EntityDtoMapper<E, D>,
        R extends RepositoryCustom<E, Q, Long>,
        S extends CommonService<E, D>>
        implements CommonController<D> {

    private final S service;

    @Autowired
    protected AbstractController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<D> save(@RequestBody D dto) {
        return service.save(dto).map(ResponseEntity::ok)
                .orElseThrow(() -> new DatabaseException(ErrorType.ENTITY_NOT_SAVED.getDescription(), dto.toString()));
    }

    @Override
    public ResponseEntity<List<D>> saveAll(@RequestBody List<D> dtoList) {
        return ResponseEntity.ok(service.saveAll(dtoList));
    }

    @Override
    public ResponseEntity<D> update(@RequestBody D dto) {
        return service.update(dto).map(ResponseEntity::ok)
                .orElseThrow(() -> new DatabaseException(ErrorType.ENTITY_NOT_UPDATED.getDescription(), dto.toString()));
    }

    @Override
    public ResponseEntity<D> get(@RequestBody Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @Override
    public ResponseEntity<List<D>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    public ResponseEntity<Boolean> delete(@RequestBody Long id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

    @Override
    public ResponseEntity<Boolean> deleteAll() {
        return ResponseEntity.ok(service.deleteAll());
    }
}
