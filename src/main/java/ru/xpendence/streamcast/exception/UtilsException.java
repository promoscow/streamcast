package ru.xpendence.streamcast.exception;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.11.2018
 * Time: 14:30
 * e-mail: 2262288@gmail.com
 */
public class UtilsException extends CommonException {

    public UtilsException(String message) {
        super(message);
    }

    public UtilsException(String message, Long id) {
        super(message, id);
    }

    public UtilsException(String message, String entity) {
        super(message, entity);
    }
}
