package ru.xpendence.streamcast.dto.mapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import ru.xpendence.streamcast.domain.AbstractEntity;
import ru.xpendence.streamcast.dto.AbstractDto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 09.09.18
 * Time: 22:21
 * e-mail: 2262288@gmail.com
 */
public interface EntityDtoMapper<E extends AbstractEntity, D extends AbstractDto> {

    @FunctionalInterface
    interface Action {
        void execute();
    }

    E convertToEntity(D dto);

    E convertToEntity(D dto, E entity);

    D convertToDto(E entity);

    D convertToDto(E entity, D dto);

    default <T> void whenNotNull(T o, Consumer<T> c) {
        whenNotNull(o, c, null);
    }

    default <T> void whenNotNull(T o, Consumer<T> c, Action nullAction) {
        when(o, Objects::nonNull, c, nullAction);
    }

    default <T> void whenNot(T o, Predicate<T> p, Consumer<T> c) {
        when(o, p.negate(), c, null);
    }

    default <T> void when(T o, Predicate<T> p, Consumer<T> c) {
        when(o, p, c, null);
    }

    default <T> void when(T o, Predicate<T> p, Consumer<T> c, Action nullAction) {
        if (p.test(o)) {
            c.accept(o);
        } else {
            if (nullAction != null) {
                nullAction.execute();
            }
        }
    }

    default <S extends AbstractEntity> Long toId(S item) {
        return Objects.isNull(item) ? null : item.getId();
    }

    default <S extends AbstractEntity> List<Long> toIdList(List<S> items) {
        return items == null || items.isEmpty() ? Collections.emptyList() :
                items.stream().map(AbstractEntity::getId).collect(Collectors.toList());
    }

    default <S extends AbstractEntity> List<S> toEntityList(Iterable<S> src) {
        return StreamSupport.stream(src.spliterator(), false).collect(Collectors.toList());
    }

    default List<E> convertToEntityList(List<D> dtoList) {
        return dtoList.stream().map(this::convertToEntity).collect(Collectors.toList());
    }

    default List<D> convertToDtoList(List<E> entities) {
        return entities.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    default Page<D> convertToDtoPage(Page<E> entities, Pageable pageable, Long count) {
        return new PageImpl<>(entities.stream().map(this::convertToDto).collect(Collectors.toList()), pageable, count);
    }
}
