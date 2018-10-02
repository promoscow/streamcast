package ru.xpendence.streamcast.config;

import org.springframework.context.annotation.Configuration;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 02.10.18
 * Time: 21:06
 * e-mail: 2262288@gmail.com
 */
@Configuration
//@EnableJpaRepositories(value = "ru.xpendence.streamcast.repository", repositoryBaseClass = RepositoryCustom.class)
public class TransactionManagerConfig {

//    @Bean
//    @Autowired
//    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//
//    @Bean
//    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
//        return entityManagerFactory.createEntityManager();
//    }
//
//    @Bean
//    public EntityManagerFactory entityManagerFactory(FactoryBean<EntityManagerFactory> entityManagerFactoryBean)
//            throws Exception {
//        return entityManagerFactoryBean.getObject();
//    }
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        return new HibernateJpaVendorAdapter();
//    }
//
//    @Bean
//    public FactoryBean<EntityManagerFactory> entityManagerFactoryBean(DataSource dataSource,
//                                                                      JpaVendorAdapter jpaVendorAdapter,
//                                                                      @Qualifier("hibernate-props") Properties properties) {
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setDataSource(dataSource);
//        factory.setJpaVendorAdapter(jpaVendorAdapter);
//        factory.setPackagesToScan("ru.xpendence.streamcast.domain");
//        factory.setJpaProperties(properties);
//        factory.setPersistenceUnitName("entityManagerFactoryBean");
//        return factory;
//    }
}
