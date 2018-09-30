package ru.xpendence.streamcast.exception;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 21.09.18
 * Time: 9:25
 * e-mail: 2262288@gmail.com
 */
public class DatabaseException extends CommonException {

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Long id) {
        super(message, id);
    }

    public DatabaseException(String message, String entity) {
        super(message, entity);
    }
}
