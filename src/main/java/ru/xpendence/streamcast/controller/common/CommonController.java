package ru.xpendence.streamcast.controller.common;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.streamcast.dto.AbstractDto;
import ru.xpendence.streamcast.dto.transfer.Validation;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 11:10
 * e-mail: 2262288@gmail.com
 */
public interface CommonController<D extends AbstractDto> {

    @PostMapping
    ResponseEntity<D> save(@Validated(Validation.New.class) @RequestBody D dto);

    @PostMapping("/all")
    ResponseEntity<List<D>> saveAll(@Validated(Validation.Exists.class) @RequestBody List<D> dtoList);

    @PutMapping
    ResponseEntity<D> update(@RequestBody D dto);

    @GetMapping
    ResponseEntity<D> get(@RequestParam Long id);

    @GetMapping("/all")
    ResponseEntity<Page<D>> getAll(Predicate predicate, Pageable pageable);

    @DeleteMapping
    ResponseEntity<Boolean> delete(@RequestParam Long id);

    @DeleteMapping("/all")
    ResponseEntity<Boolean> deleteAll();
}
