package ru.xpendence.streamcast.controller;

import org.junit.Test;
import org.springframework.http.MediaType;
import ru.xpendence.streamcast.AbstractControllerTest;
import ru.xpendence.streamcast.dto.MessageDto;
import ru.xpendence.streamcast.util.JsonUtils;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.11.2018
 * Time: 15:11
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
public class MessageControllerTest extends AbstractControllerTest {

    @Test
    public void sample() throws Exception {
        result = mockMvc.perform(post("/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtils.toJson(createMessageDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_UTF8_VALUE, result.getResponse().getContentType());
    }

    private MessageDto createMessageDto() {
        return new MessageDto(

        );
    }
}