package ru.xpendence.streamcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import ru.xpendence.streamcast.AbstractControllerTest;
import ru.xpendence.streamcast.dto.MessageDto;
import ru.xpendence.streamcast.dto.mapper.impl.MessageMapper;
import ru.xpendence.streamcast.service.util.JsonMapper;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.11.2018
 * Time: 15:11
 * e-mail: 2262288@gmail.com
 */
public class MessageControllerTest extends AbstractControllerTest {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private JsonMapper jsonMapper;

    @Override
    public void save() throws Exception {
        result = mockMvc.perform(post("/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.toJson(createMessageDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_UTF8_VALUE, result.getResponse().getContentType());
    }

    @Override
    public void update() throws Exception {
        message.setText("Updated text of message: " + System.currentTimeMillis());
        result = mockMvc.perform(put("/message")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMapper.toJson(messageMapper.convertToDto(message))))
                .andDo(print())
                // FIXME: 11.11.18 заэкспектить все возможные поля во всех тестах контроллера
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_UTF8_VALUE, result.getResponse().getContentType());
    }

    @Override
    public void getTest() throws Exception {
        result = mockMvc.perform(get("/message")
                .param("id", String.valueOf(message.getId())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_UTF8_VALUE, result.getResponse().getContentType());
    }

    @Override
    public void getAll() throws Exception {
        result = mockMvc.perform(get("/message/all")
                .param("page", "0")
                .param("size", "20")
                .param("topic", String.valueOf(topic.getId())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_UTF8_VALUE, result.getResponse().getContentType());
    }

    @Override
    public void deleteTest() throws Exception {
        result = mockMvc.perform(delete("/message").param("id", String.valueOf(message.getId())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_UTF8_VALUE, result.getResponse().getContentType());
    }

    private MessageDto createMessageDto() {
        return new MessageDto(
                topic.getId(), "Text message: " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)
        );
    }
}