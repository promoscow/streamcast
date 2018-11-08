package ru.xpendence.streamcast.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import ru.xpendence.streamcast.attributes.TransferType;
import ru.xpendence.streamcast.controller.common.AbstractController;
import ru.xpendence.streamcast.domain.ApiLog;
import ru.xpendence.streamcast.service.ApiLogService;
import ru.xpendence.streamcast.util.JsonUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.11.18
 * Time: 21:54
 * e-mail: 2262288@gmail.com
 */
@Aspect
@Component
public class ApiLogProcessor {

    private final ApiLogService service;

    @Autowired
    public ApiLogProcessor(ApiLogService service) {
        this.service = service;
    }

    @Before(value = "@annotation(request) && args(dto)")
    public void before(PostApiRequest request, Object dto) {
        service.save(ApiLog.of(
                LocalDateTime.now(),
                TransferType.REQUEST.name(),
                HttpMethod.POST.name(),
                getPath(),
                JsonUtils.toJson(dto)
        ));
    }

    //выяснить через рефлексию
    //для этого нужно как-то получить в процессор имя класса, который он вызывает
    //может быть, дёрнуть конструктор?
    private String getPath() {
        AbstractController abstractController = (AbstractController) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class<?>[] { AbstractController.class },
                new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Annotation[] annotations = proxy.getClass().getAnnotations();
                return null;
            }
        });
        return null;
    }
}
