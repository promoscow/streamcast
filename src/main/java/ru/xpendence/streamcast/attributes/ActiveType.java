package ru.xpendence.streamcast.attributes;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.09.2018
 * Time: 22:15
 * e-mail: 2262288@gmail.com
 */
public enum ActiveType {
    DELETED(0),
    ENABLED(1);

    private Integer id;

    ActiveType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
