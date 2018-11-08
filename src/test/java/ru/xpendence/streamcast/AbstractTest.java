package ru.xpendence.streamcast;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.xpendence.streamcast.config.MainConfig;
import ru.xpendence.streamcast.sample.TestConfig;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.11.2018
 * Time: 15:12
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@ContextConfiguration(classes = {
        MainConfig.class,
        TestConfig.class
})
public abstract class AbstractTest {
}
