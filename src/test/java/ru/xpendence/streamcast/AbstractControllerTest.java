package ru.xpendence.streamcast;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.xpendence.streamcast.domain.Message;
import ru.xpendence.streamcast.domain.Topic;
import ru.xpendence.streamcast.domain.User;
import ru.xpendence.streamcast.repository.MessageRepository;
import ru.xpendence.streamcast.repository.TopicRepository;
import ru.xpendence.streamcast.repository.UserRepository;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.11.2018
 * Time: 15:13
 * e-mail: 2262288@gmail.com
 */
public abstract class AbstractControllerTest extends AbstractTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private MessageRepository messageRepository;

    protected User author;
    protected Topic topic;
    protected Message message;

    protected MvcResult result;
    protected MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        author = userRepository.save(createAuthor());
        topic = topicRepository.save(createTopic());
        message = messageRepository.save(createMessage());
    }

    private Message createMessage() {
        return new Message(topic, "Test message " + System.currentTimeMillis());
    }

    private Topic createTopic() {
        return new Topic(author, "Test topic " + System.currentTimeMillis());
    }

    protected User createAuthor() {
        return new User();
    }
}
