package ru.xpendence.streamcast.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.xpendence.streamcast.attributes.StatusCode;
import ru.xpendence.streamcast.exception.UtilsException;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.11.2018
 * Time: 14:26
 * e-mail: 2262288@gmail.com
 */
public class JsonUtils {

    public static String toJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new UtilsException(StatusCode.ERROR_WRITING_OBJECT_TO_JSON.getDescription());
        }
    }
}
