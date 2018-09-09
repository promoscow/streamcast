package ru.xpendence.streamcast.domain;

import ru.xpendence.streamcast.attributes.ActiveType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.09.2018
 * Time: 15:35
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    private static final int START_SEQ = 1000000000;

    private Long id;
    private LocalDateTime created;
    private LocalDateTime updated;
    private ActiveType active = ActiveType.ENABLED;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    public Long getId() {
        return id;
    }

    @Column(name = "created", updatable = false)
    public LocalDateTime getCreated() {
        return created;
    }

    @Column(name = "updated", insertable = false)
    public LocalDateTime getUpdated() {
        return updated;
    }

    @PrePersist
    void onCreate() {
        if (Objects.isNull(this.getCreated())) {
            this.setCreated(LocalDateTime.now());
        }
    }

    @PreUpdate
    void onUpdate() {
        this.setUpdated(LocalDateTime.now());
    }

    @Column(name = "active")
    public ActiveType getActive() {
        return active;
    }

    public void setActive(ActiveType active) {
        this.active = active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
