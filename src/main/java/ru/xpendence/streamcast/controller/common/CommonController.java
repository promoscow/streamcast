package ru.xpendence.streamcast.controller.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.streamcast.domain.AbstractEntity;
import ru.xpendence.streamcast.dto.AbstractDto;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 22.09.18
 * Time: 11:10
 * e-mail: 2262288@gmail.com
 */
public interface CommonController<E extends AbstractEntity, D extends AbstractDto> {

    @PostMapping
    ResponseEntity<D> save(@RequestBody D dto);

    @PostMapping("/all")
    ResponseEntity<List<D>> saveAll(@RequestBody List<D> dtoList);

    @PutMapping
    ResponseEntity<D> update(@RequestBody D dto);

    @GetMapping
    ResponseEntity<D> get(@RequestParam Long id);

    @GetMapping("/all")
    ResponseEntity<List<D>> getAll();

    @DeleteMapping
    ResponseEntity<Boolean> delete(@RequestParam Long id);

    @DeleteMapping("/all")
    ResponseEntity<Boolean> deleteAll();
}
