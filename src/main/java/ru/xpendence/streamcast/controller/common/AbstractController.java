package ru.xpendence.streamcast.controller.common;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.xpendence.streamcast.aspect.*;
import ru.xpendence.streamcast.attributes.StatusCode;
import ru.xpendence.streamcast.dto.AbstractDto;
import ru.xpendence.streamcast.exception.DatabaseException;
import ru.xpendence.streamcast.service.common.CommonService;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 11:15
 * e-mail: 2262288@gmail.com
 */
public abstract class AbstractController<
        D extends AbstractDto,
        S extends CommonService<D>>
        implements CommonController<D> {

    private final S service;

    @Autowired
    protected AbstractController(S service) {
        this.service = service;
    }

    @PostApiRequest
    @PostApiResponse
    @Override
    public ResponseEntity<D> save(@RequestBody D dto) {
        return service.save(dto).map(ResponseEntity::ok)
                .orElseThrow(() -> new DatabaseException(StatusCode.ENTITY_NOT_SAVED.getDescription(), dto.toString()));
    }

    @PostApiRequest
    @PostApiResponse
    @Override
    public ResponseEntity<List<D>> saveAll(@RequestBody List<D> dtoList) {
        return ResponseEntity.ok(service.saveAll(dtoList));
    }

    @PutApiRequest
    @PutApiResponse
    @Override
    public ResponseEntity<D> update(@RequestBody D dto) {
        return service.update(dto).map(ResponseEntity::ok)
                .orElseThrow(() -> new DatabaseException(StatusCode.ENTITY_NOT_UPDATED.getDescription(), dto.toString()));
    }

    @GetApiRequest
    @GetApiResponse
    @Override
    public ResponseEntity<D> get(@RequestParam Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetApiRequest
    @GetApiResponse
    @Override
    public ResponseEntity<Page<D>> getAll(Predicate predicate, Pageable pageable) {
        return ResponseEntity.ok(service.getAll(predicate, pageable));
    }

    @DeleteApiRequest
    @DeleteApiResponse
    @Override
    public ResponseEntity<Boolean> delete(@RequestParam Long id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

    @DeleteApiRequest
    @DeleteApiResponse
    @Override
    public ResponseEntity<Boolean> deleteAll() {
        return ResponseEntity.ok(service.deleteAll());
    }
}
