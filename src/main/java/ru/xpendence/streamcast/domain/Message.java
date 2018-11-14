package ru.xpendence.streamcast.domain;

import lombok.NoArgsConstructor;
import lombok.Setter;
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
@SQLDelete(sql = "UPDATE messages SET active = 0 WHERE id = ?")
@Where(clause = "active = 1")
@Setter
@NoArgsConstructor
public class Message extends AbstractEntity {

    private Topic topic;
    private String text;

    public Message(Topic topic, String text) {
        this.topic = topic;
        this.text = text;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "topics")
    public Topic getTopic() {
        return topic;
    }

    @Column(name = "text")
    public String getText() {
        return text;
    }
}
