package ru.xpendence.streamcast.domain;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.09.2018
 * Time: 15:28
 * e-mail: 2262288@gmail.com
 */
@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE members SET active = 0 WHERE id = ?")
@Where(clause = "active = 1")
public class User extends AbstractEntity {

    private List<User> authors;
    private List<User> subscribers;
    private List<Topic> topicsCreated;
    private List<Topic> topicsSubscribed;
    private List<Message> messagesPosted;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "authors_subscribers",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "subscriber_id")
    )
    public List<User> getAuthors() {
        return authors;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "authors_subscribers",
            joinColumns = @JoinColumn(name = "subscriber_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    public List<User> getSubscribers() {
        return subscribers;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
    public List<Topic> getTopicsCreated() {
        return topicsCreated;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "subscribers_topics",
            joinColumns = @JoinColumn(name = "subscriber_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    public List<Topic> getTopicsSubscribed() {
        return topicsSubscribed;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
    public List<Message> getMessagesPosted() {
        return messagesPosted;
    }

    public void setAuthors(List<User> authors) {
        this.authors = authors;
    }

    public void setSubscribers(List<User> subscribers) {
        this.subscribers = subscribers;
    }

    public void setTopicsCreated(List<Topic> topicsCreated) {
        this.topicsCreated = topicsCreated;
    }

    public void setTopicsSubscribed(List<Topic> topicsSubscribed) {
        this.topicsSubscribed = topicsSubscribed;
    }

    public void setMessagesPosted(List<Message> messagesPosted) {
        this.messagesPosted = messagesPosted;
    }
}
