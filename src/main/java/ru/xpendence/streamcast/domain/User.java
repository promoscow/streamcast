package ru.xpendence.streamcast.domain;

import lombok.Setter;
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
@Setter
public class User extends AbstractEntity {

    private List<User> authors;
    private List<User> subscribers;
    private List<Topic> topicsCreated;
    private List<Topic> topicsSubscribed;
    private List<Message> messagesPosted;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "authors_subscribers",
            joinColumns = @JoinColumn(name = "subscriber_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    public List<User> getAuthors() {
        return authors;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "authors_subscribers",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "subscriber_id")
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
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "subscriber_id")
    )
    public List<Topic> getTopicsSubscribed() {
        return topicsSubscribed;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
    public List<Message> getMessagesPosted() {
        return messagesPosted;
    }
}
