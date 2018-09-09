package ru.xpendence.streamcast.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 09.09.18
 * Time: 22:24
 * e-mail: 2262288@gmail.com
 */
public class ResponseEntityUtils {

    public static HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return headers;
    }
}
