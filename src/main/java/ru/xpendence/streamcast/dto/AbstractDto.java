package ru.xpendence.streamcast.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.ToString;
import ru.xpendence.streamcast.dto.transfer.Validation;
import ru.xpendence.streamcast.dto.transfer.View;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 09.09.18
 * Time: 22:20
 * e-mail: 2262288@gmail.com
 */
@ToString
@Data
public abstract class AbstractDto implements Serializable {

    @Null(groups = {Validation.New.class})
    @NotNull(groups = {Validation.Exists.class})
    @JsonView(value = {View.New.class, View.Exists.class})
    private Long id;

    @Null
    @JsonView(value = {View.New.class, View.Exists.class})
    private String errorMessage;

    @Null(groups = {Validation.New.class, Validation.Exists.class})
    @JsonView(value = {View.New.class})
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime created;

    @JsonView(value = {View.DoNotShow.class})
    private Long active;
}
