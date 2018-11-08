package ru.xpendence.streamcast.config;

import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.11.2018
 * Time: 13:18
 * e-mail: 2262288@gmail.com
 */
@Component
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
        executor.setPoolSize(10);
        executor.initialize();
        return executor;
    }
}
