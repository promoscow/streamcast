package ru.xpendence.streamcast.attributes;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 21.09.18
 * Time: 9:43
 * e-mail: 2262288@gmail.com
 */
public enum StatusCode {
    ENTITY_NOT_FOUND("Entity not found by id: %d"),
    ENTITY_NOT_SAVED("Entity not saved: %s"),
    ENTITY_NOT_UPDATED("Entity not updated: %s"),
    ERROR_SAVING_LOG("Api log not saved: %s"),
    ERROR_WRITING_OBJECT_TO_JSON("Failed to write object to JSON");

    private String description;

    StatusCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
