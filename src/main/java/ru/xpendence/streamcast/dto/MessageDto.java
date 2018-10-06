package ru.xpendence.streamcast.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 28.09.18
 * Time: 22:13
 * e-mail: 2262288@gmail.com
 */
@ToString
@EqualsAndHashCode(callSuper = false)
@Builder
public class MessageDto extends AbstractDto {

    private Long author;
    private Long topic;
    private String text;

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Long getTopic() {
        return topic;
    }

    public void setTopic(Long topic) {
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
