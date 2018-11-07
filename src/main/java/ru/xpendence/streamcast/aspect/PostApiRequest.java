package ru.xpendence.streamcast.aspect;

import java.lang.annotation.*;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.11.18
 * Time: 21:46
 * e-mail: 2262288@gmail.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface PostApiRequest {
}
