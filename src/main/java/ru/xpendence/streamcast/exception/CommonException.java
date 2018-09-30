package ru.xpendence.streamcast.exception;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 30.09.18
 * Time: 19:52
 * e-mail: 2262288@gmail.com
 */
abstract class CommonException extends RuntimeException {

    CommonException(String message) {
        super(message);
    }

    CommonException(String message, Long id) {
        super(String.format(message, id));
    }

    CommonException(String message, String entity) {
        super(String.format(message, entity));
    }
}
