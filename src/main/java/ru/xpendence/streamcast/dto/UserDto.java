package ru.xpendence.streamcast.dto;

import lombok.*;
import ru.xpendence.streamcast.dto.transfer.Validation;

import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 11.09.18
 * Time: 9:29
 * e-mail: 2262288@gmail.com
 */
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto extends AbstractDto {

    @Null(groups = {Validation.New.class})
    private List<Long> authors;

    @Null(groups = {Validation.New.class, Validation.Exists.class})
    private List<Long> subscribers;

    @Null(groups = {Validation.New.class, Validation.Exists.class})
    private List<Long> topicsCreated;

    private List<Long> topicsSubscribed;
    private UserDetailsDto details;

    @Builder
    public UserDto(Long id,
                   String errorMessage,
                   LocalDateTime created,
                   Integer active,
                   List<Long> authors,
                   List<Long> subscribers,
                   List<Long> topicsCreated,
                   List<Long> topicsSubscribed
    ) {
        super(id, errorMessage, created, active);
        this.authors = authors;
        this.subscribers = subscribers;
        this.topicsCreated = topicsCreated;
        this.topicsSubscribed = topicsSubscribed;
    }
}





