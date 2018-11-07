package ru.xpendence.streamcast.aspect;

import java.lang.annotation.*;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.11.18
 * Time: 21:49
 * e-mail: 2262288@gmail.com
 *
 * Аннотация служит для логирования запросов и ответов в специальную таблицу.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface PostApiResponse {
}
