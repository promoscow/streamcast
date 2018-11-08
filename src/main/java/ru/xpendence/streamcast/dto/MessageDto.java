package ru.xpendence.streamcast.dto;

import lombok.*;
import ru.xpendence.streamcast.dto.transfer.Validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 28.09.18
 * Time: 22:13
 * e-mail: 2262288@gmail.com
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class MessageDto extends AbstractDto {

    @NotNull(groups = {Validation.New.class})
    @Null(groups = {Validation.Exists.class})
    private Long topic;

    @NotNull(groups = {Validation.New.class})
    private String text;

    public MessageDto(Long id,
                      String errorMessage,
                      LocalDateTime created,
                      Integer active,
                      Long topic,
                      String text) {
        super(id, errorMessage, created, active);
        this.topic = topic;
        this.text = text;
    }

    public MessageDto(Long topic, String text) {
        this.topic = topic;
        this.text = text;
    }
}
