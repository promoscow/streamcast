package ru.xpendence.streamcast.dto;

import ru.xpendence.streamcast.domain.Topic;
import ru.xpendence.streamcast.domain.User;

import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 28.09.18
 * Time: 22:13
 * e-mail: 2262288@gmail.com
 */
public class MessageDto extends AbstractDto {

    private User author;
    private Topic topic;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageDto that = (MessageDto) o;
        return Objects.equals(author, that.author) &&
                Objects.equals(topic, that.topic);
    }

    @Override
    public int hashCode() {

        return Objects.hash(author, topic);
    }
}
