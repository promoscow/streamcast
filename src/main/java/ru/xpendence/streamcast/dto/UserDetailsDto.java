package ru.xpendence.streamcast.dto;

import lombok.*;
import ru.xpendence.streamcast.dto.transfer.Validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 16.11.2018
 * Time: 11:46
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDetailsDto extends AbstractDto {

    @NotNull(groups = {Validation.New.class})
    private Long user;

    private String nickname;

    @Null(groups = {Validation.New.class})
    private String hashcode;

    private String description;
    private String verificationStatus;
}
