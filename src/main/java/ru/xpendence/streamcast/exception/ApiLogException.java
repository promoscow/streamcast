package ru.xpendence.streamcast.exception;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.11.2018
 * Time: 14:22
 * e-mail: 2262288@gmail.com
 */
public class ApiLogException extends CommonException {

    public ApiLogException(String message) {
        super(message);
    }

    public ApiLogException(String message, Long id) {
        super(message, id);
    }

    public ApiLogException(String message, String entity) {
        super(message, entity);
    }
}
