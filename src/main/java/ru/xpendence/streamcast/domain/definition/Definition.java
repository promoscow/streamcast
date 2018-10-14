package ru.xpendence.streamcast.domain.definition;

import java.lang.annotation.*;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 14.10.18
 * Time: 19:42
 * e-mail: 2262288@gmail.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface Definition {

    Class<?> entity();

    Class<?> repository();

    Class<?> mapper();
}
