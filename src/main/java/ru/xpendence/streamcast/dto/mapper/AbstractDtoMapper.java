package ru.xpendence.streamcast.dto.mapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.xpendence.streamcast.domain.AbstractEntity;
import ru.xpendence.streamcast.dto.AbstractDto;

import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 09.09.18
 * Time: 22:23
 * e-mail: 2262288@gmail.com
 */
public abstract class AbstractDtoMapper<E extends AbstractEntity, D extends AbstractDto>
        implements EntityDtoMapper<E, D> {

    protected Class<E> entityClass;
    protected Class<D> dtoClass;

    @Autowired
    protected ModelMapper mapper;

    @Override
    public E convertToEntity(D dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, entityClass);
    }

    @Override
    public E convertToEntity(D dto, E entity) {
        if (Objects.isNull(dto)) {
            return entity;
        }
        if (Objects.isNull(entity)) {
            return convertToEntity(dto);
        }
        mapper.map(dto, entity);
        return entity;
    }

    @Override
    public D convertToDto(E entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, dtoClass);
    }

    @Override
    public D convertToDto(E entity, D dto) {
        mapper.map(entity, dto);
        return dto;
    }

    protected void toDtoConverterImpl(E source, D destination) {
    }

    protected void toEntityConverterImpl(D source, E destination) {
    }

    protected Converter<E, D> toDtoConverter() {
        return context -> {
            E source = context.getSource();
            D destination = context.getDestination();
            toDtoConverterImpl(source, destination);
            return destination;
        };
    }

    protected Converter<D, E> toEntityConverter() {
        return context -> {
            D source = context.getSource();
            E destination = context.getDestination();
            toEntityConverterImpl(source, destination);
            return destination;
        };
    }
}
