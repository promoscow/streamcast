package ru.xpendence.streamcast.domain;

import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 16.11.2018
 * Time: 11:12
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Entity
@Table(name = "user_details")
@SQLDelete(sql = "UPDATE user_details SET active = 0 WHERE id = ?")
@Where(clause = "active = 1")
@Setter
public class UserDetails extends AbstractEntity {

    private User user;
    private String nickName;
    private String hashcode;
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    @Column(name = "hashcode")
    public String getHashcode() {
        return hashcode;
    }

    @Column(name = "description", length = 2000)
    public String getDescription() {
        return description;
    }
}
