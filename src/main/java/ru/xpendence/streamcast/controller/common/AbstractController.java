package ru.xpendence.streamcast.controller.common;

import com.querydsl.core.types.dsl.EntityPathBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import ru.xpendence.streamcast.base.ErrorType;
import ru.xpendence.streamcast.domain.AbstractEntity;
import ru.xpendence.streamcast.dto.AbstractDto;
import ru.xpendence.streamcast.dto.mapper.EntityDtoMapper;
import ru.xpendence.streamcast.exception.SampleException;
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
        S extends CommonService<E, D, Q, M, R>>
        implements CommonController<E, D> {

    private final S service;

    @Autowired
    protected AbstractController(S service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<D> save(D dto) {
        return service.save(dto).map(ResponseEntity::ok)
                .orElseThrow(() -> new SampleException(
                        String.format(ErrorType.ENTITY_NOT_SAVED.getDescription(), dto.toString())
                ));
    }

    @Override
    public ResponseEntity<List<D>> saveAll(List<D> dtoList) {
        return null;
    }

    @Override
    public ResponseEntity<D> update(D dto) {
        return null;
    }

    @Override
    public ResponseEntity<D> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<E>> getAll() {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Boolean deleteAll() {
        return null;
    }
}
