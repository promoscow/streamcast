package ru.xpendence.streamcast.dto.mapper;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import ru.xpendence.streamcast.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 09.09.18
 * Time: 22:15
 * e-mail: 2262288@gmail.com
 */
@Component
public class MapperAnnotationProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(@Nullable Object bean, String beanName) {
        return configureInjection(bean);
    }

    @Override
    public Object postProcessAfterInitialization(@Nullable Object bean, String beanName) {
        return bean;
    }

    private Object configureInjection(Object bean) {
        Class<?> managedBeanClass = bean.getClass();
        Mapper mapper = managedBeanClass.getAnnotation(Mapper.class);
        if (Objects.nonNull(mapper)) {
            ReflectionUtils.doWithFields(managedBeanClass, new MapperCallback(bean,
                    Stream.<Map.Entry<String, Class<?>>>of(
                            CollectionUtils.entry(mapper.entityClassField(), mapper.entity()),
                            CollectionUtils.entry(mapper.dtoClassField(), mapper.dto())
                    ).collect(CollectionUtils.entriesToMap())));
        }
        return bean;
    }

    private static class MapperCallback implements ReflectionUtils.FieldCallback {

        private Object bean;
        private Map<String, Class<?>> fieldMap;

        MapperCallback(Object bean, Map<String, Class<?>> fieldMap) {
            this.bean = bean;
            this.fieldMap = fieldMap;
        }

        @Override
        public void doWith(@Nullable Field field) throws IllegalAccessException {
            assert field != null;
            String fieldName = field.getName();
            if (!fieldMap.containsKey(fieldName)) {
                return;
            }
            ReflectionUtils.makeAccessible(field);
            Class<?> targetClass = fieldMap.get(fieldName);
            checkTypes(field, targetClass);
            field.set(bean, targetClass);
        }

        private void checkTypes(Field field, Class<?> targetClass) {
            Class<?> expectedClass = Stream.of(ResolvableType.forField(field).getGenerics()).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(String.format("Can`t get generic type for %s", field.getName())))
                    .resolve();

            if (expectedClass != null && !expectedClass.isAssignableFrom(targetClass)) {
                throw new IllegalArgumentException(String.format("Can`t assign targetClass: %s, to expectedClass: %s",
                        targetClass, expectedClass));
            }
        }
    }
}
