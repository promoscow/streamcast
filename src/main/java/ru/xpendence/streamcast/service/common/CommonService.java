package ru.xpendence.streamcast.service.common;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import ru.xpendence.streamcast.dto.AbstractDto;

import java.util.List;
import java.util.Optional;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 09.09.18
 * Time: 22:38
 * e-mail: 2262288@gmail.com
 */
public interface CommonService<D extends AbstractDto> {

    @Transactional
    Optional<D> save(D dto);

    @Transactional
    List<D> saveAll(List<D> dtoList);

    @Transactional
    Optional<D> update(D dto);

    @Transactional
    D get(Long id);

    @Transactional
    Page<D> getAll(Predicate predicate, Pageable pageable);

    Boolean deleteById(Long id);

    Boolean deleteAll();

    void validate(Long id);
}
