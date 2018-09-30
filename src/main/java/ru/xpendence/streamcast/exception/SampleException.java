package ru.xpendence.streamcast.exception;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 21.09.18
 * Time: 9:25
 * e-mail: 2262288@gmail.com
 */
public class SampleException extends RuntimeException {

    public SampleException(String message) {
        super(message);
    }

    public SampleException(String message, Long id) {
        super(String.format(message, id));
    }

    public SampleException(String message, String entity) {
        super(String.format(message, entity));
    }
}
