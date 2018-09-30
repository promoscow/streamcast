package ru.xpendence.streamcast.dto;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.xpendence.streamcast.domain.Topic;
import ru.xpendence.streamcast.domain.User;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 28.09.18
 * Time: 22:13
 * e-mail: 2262288@gmail.com
 */
@ToString
@EqualsAndHashCode
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
}
