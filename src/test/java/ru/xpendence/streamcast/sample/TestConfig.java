package ru.xpendence.streamcast.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 14.10.18
 * Time: 19:28
 * e-mail: 2262288@gmail.com
 */
@Configuration
@ComponentScan(basePackages = "ru.xpendence.streamcast.sample")
public class TestConfig {

    @Profile("dev")
    @Bean(destroyMethod = "")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("devdb;DATABASE_TO_UPPER=false")
                .build();
    }
}
