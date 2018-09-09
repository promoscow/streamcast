package ru.xpendence.streamcast.domain;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.09.2018
 * Time: 15:34
 * e-mail: 2262288@gmail.com
 */
@Table(name = "messages")
@Entity
@SQLDelete(sql = "UPDATE members SET active = 0 WHERE id = ?")
@Where(clause = "active = 1")
//@EqualsAndHashCode
//@Builder
public class Message extends AbstractEntity {

    private User author;
    private Topic topic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authors")
    public User getAuthor() {
        return author;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "topics")
    public Topic getTopic() {
        return topic;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
