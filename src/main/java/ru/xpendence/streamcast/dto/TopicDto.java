package ru.xpendence.streamcast.dto;

import java.util.List;
import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 28.09.18
 * Time: 22:09
 * e-mail: 2262288@gmail.com
 */
public class TopicDto extends AbstractDto {

    private Long author;
    private List<Long> subscribers;
    private List<Long> messages;

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public List<Long> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Long> subscribers) {
        this.subscribers = subscribers;
    }

    public List<Long> getMessages() {
        return messages;
    }

    public void setMessages(List<Long> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicDto topicDto = (TopicDto) o;
        return Objects.equals(author, topicDto.author) &&
                Objects.equals(subscribers, topicDto.subscribers) &&
                Objects.equals(messages, topicDto.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, subscribers, messages);
    }
}
