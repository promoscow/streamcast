package ru.xpendence.streamcast.domain;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.09.2018
 * Time: 15:38
 * e-mail: 2262288@gmail.com
 */
@Entity
@Table(name = "topics")
@SQLDelete(sql = "UPDATE members SET active = 0 WHERE id = ?")
@Where(clause = "active = 1")
public class Topic extends AbstractEntity {

    private User author;
    private List<User> subscribers;
    private List<Message> messages;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users")
    public User getAuthor() {
        return author;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "subscribers_topics",
            joinColumns = @JoinColumn(name = "subscriber_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    public List<User> getSubscribers() {
        return subscribers;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "topic")
    public List<Message> getMessages() {
        return messages;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setSubscribers(List<User> subscribers) {
        this.subscribers = subscribers;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
