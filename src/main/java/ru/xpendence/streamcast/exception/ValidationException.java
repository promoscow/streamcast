package ru.xpendence.streamcast.exception;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 30.09.18
 * Time: 19:51
 * e-mail: 2262288@gmail.com
 */
public class ValidationException extends CommonException {

    ValidationException(String message) {
        super(message);
    }

    ValidationException(String message, Long id) {
        super(message, id);
    }

    ValidationException(String message, String entity) {
        super(message, entity);
    }
}
