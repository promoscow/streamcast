package ru.xpendence.streamcast.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.11.2018
 * Time: 13:10
 * e-mail: 2262288@gmail.com
 */
@Entity
@Table(name = "logs")
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiLog extends AbstractEntity {

    private LocalDateTime eventDateTime;
    private String transferType;
    private String httpMethod;
    private String path;
    private String body;

    public static ApiLog of(LocalDateTime eventDateTime,
                            String transferType,
                            String httpMethod,
                            String path,
                            String body) {
        return new ApiLog(eventDateTime, transferType, httpMethod, path, body);
    }

    public static ApiLog of(Long id,
                            LocalDateTime eventDateTime,
                            String transferType,
                            String httpMethod,
                            String path,
                            String body) {
        return new ApiLog(id, eventDateTime, transferType, httpMethod, path, body);
    }

    private ApiLog(Long id, LocalDateTime eventDateTime, String transferType, String httpMethod,
                   String path, String body) {
        super(id);
        this.eventDateTime = eventDateTime;
        this.transferType = transferType;
        this.httpMethod = httpMethod;
        this.path = path;
        this.body = body;
    }

    @Column(name = "event_date_time")
    private LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    @Column(name = "transfer_type")
    public String getTransferType() {
        return transferType;
    }

    @Column(name = "http_method")
    public String getHttpMethod() {
        return httpMethod;
    }

    @Column(name = "path", columnDefinition = "text")
    public String getPath() {
        return path;
    }

    @Column(name = "body", columnDefinition = "text")
    public String getBody() {
        return body;
    }

    @PrePersist
    void onCreate() {
        if (Objects.isNull(this.getCreated())) {
            this.setCreated(LocalDateTime.now());
        }
        if (Objects.isNull(this.getEventDateTime())) {
            this.setEventDateTime(LocalDateTime.now());
        }
    }
}