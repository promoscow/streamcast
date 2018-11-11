package ru.xpendence.streamcast.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.xpendence.streamcast.attributes.ActiveType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.09.2018
 * Time: 15:35
 * e-mail: 2262288@gmail.com
 */
@MappedSuperclass
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEntity implements Serializable {
    private static final int START_SEQ = 1000000000;

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime created;
    private LocalDateTime updated;
    private ActiveType active = ActiveType.ENABLED;

    public AbstractEntity(Long id) {
        this.id = id;
    }

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    public Long getId() {
        return id;
    }

    @Column(name = "created", updatable = false)
    LocalDateTime getCreated() {
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
}
