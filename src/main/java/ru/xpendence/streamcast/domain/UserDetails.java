package ru.xpendence.streamcast.domain;

import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import ru.xpendence.streamcast.attributes.VerificationStatus;

import javax.persistence.*;
import java.util.Objects;

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
    private String nickname;
    private String hashcode;
    private String description;
    private VerificationStatus verificationStatus = VerificationStatus.NOT_VERIFIED;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    @Column(name = "nick_name")
    public String getNickname() {
        return nickname;
    }

    @Column(name = "hashcode")
    public String getHashcode() {
        return hashcode;
    }

    @Column(name = "description", length = 2000)
    public String getDescription() {
        return description;
    }

    @Column(name = "verification_status")
    public VerificationStatus getVerificationStatus() {
        return verificationStatus;
    }

    @PrePersist
    private void setup() {
        if (Objects.isNull(hashcode)) {
            this.setHashcode(RandomStringUtils.randomAlphanumeric(10));
        }
    }
}
