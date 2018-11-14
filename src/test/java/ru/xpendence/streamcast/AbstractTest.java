package ru.xpendence.streamcast;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.11.2018
 * Time: 15:12
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories
// FIXME: 10.11.18 при переключении на dev не работает H2
@ActiveProfiles("dev")

//@ContextConfiguration(classes = {
//        MainConfig.class
//})
public abstract class AbstractTest {
}
