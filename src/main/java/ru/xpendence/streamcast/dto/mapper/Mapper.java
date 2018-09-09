package ru.xpendence.streamcast.dto.mapper;

import java.lang.annotation.*;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 09.09.18
 * Time: 22:16
 * e-mail: 2262288@gmail.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface Mapper {

    Class<?> entity();

    Class<?> dto();

    Class<?> ent = null;

    String entityClassField() default "entityClass";

    String dtoClassField() default "dtoClass";
}
