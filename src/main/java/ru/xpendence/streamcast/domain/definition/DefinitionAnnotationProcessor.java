package ru.xpendence.streamcast.domain.definition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 14.10.18
 * Time: 19:56
 * e-mail: 2262288@gmail.com
 */
@Component
public class DefinitionAnnotationProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(@Nullable Object bean, String beanName) throws BeansException {
        return configure(Objects.requireNonNull(bean), beanName);
    }

    @Override
    public Object postProcessAfterInitialization(@Nullable Object bean, String beanName) throws BeansException {
        return bean;
    }

    private Object configure(Object bean, String beanName) {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Definition.class)) {
            Definition definition = beanClass.getAnnotation(Definition.class);
            Class<?> entity = definition.entity();

        }

        return bean;
    }
}
