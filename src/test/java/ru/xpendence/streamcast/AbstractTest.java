package ru.xpendence.streamcast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.11.2018
 * Time: 15:12
 * e-mail: 2262288@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories
@ActiveProfiles("dev")

//@ContextConfiguration(classes = {
//        MainConfig.class
//})
public abstract class AbstractTest {

    @Test
    public abstract void save() throws Exception;

    @Test
    public abstract void update() throws Exception;

    @Test
    public abstract void getTest() throws Exception;

    @Test
    public abstract void getAll() throws Exception;

    @Test
    public abstract void deleteTest() throws Exception;
}
