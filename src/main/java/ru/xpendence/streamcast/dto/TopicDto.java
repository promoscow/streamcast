package ru.xpendence.streamcast.dto;

import lombok.*;
import ru.xpendence.streamcast.dto.transfer.Validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 28.09.18
 * Time: 22:09
 * e-mail: 2262288@gmail.com
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class TopicDto extends AbstractDto {

    @NotNull(groups = {Validation.New.class})
    @Null(groups = {Validation.Exists.class})
    private Long author;

    @Null(groups = {Validation.New.class, Validation.Exists.class})
    private List<Long> subscribers;

    @Null
    private List<Long> messages;

    @NotNull(groups = {Validation.New.class})
    private String topic;

    private String hashcode;

    public TopicDto() {
    }

    @Builder
    public TopicDto(Long id,
                    String errorMessage,
                    LocalDateTime created,
                    Integer active,
                    Long author,
                    List<Long> subscribers,
                    List<Long> messages,
                    String topic) {
        super(id, errorMessage, created, active);
        this.author = author;
        this.subscribers = subscribers;
        this.messages = messages;
        this.topic = topic;
    }
}
