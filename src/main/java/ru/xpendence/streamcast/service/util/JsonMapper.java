package ru.xpendence.streamcast.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import ru.xpendence.streamcast.attributes.StatusCode;
import ru.xpendence.streamcast.exception.UtilsException;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 11.11.18
 * Time: 18:46
 * e-mail: 2262288@gmail.com
 */
@Component
public class JsonMapper extends ObjectMapper {

    public JsonMapper() {
        this.findAndRegisterModules();
    }

    public String toJson(Object object) {
        try {
            return this.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new UtilsException(StatusCode.ERROR_WRITING_OBJECT_TO_JSON.getDescription());
        }
    }
}
