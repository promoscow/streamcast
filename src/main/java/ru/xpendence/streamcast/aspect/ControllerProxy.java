package ru.xpendence.streamcast.aspect;

import ru.xpendence.streamcast.controller.common.AbstractController;
import ru.xpendence.streamcast.dto.AbstractDto;
import ru.xpendence.streamcast.service.common.CommonService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 09.11.2018
 * Time: 15:16
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
public class ControllerProxy<D extends AbstractDto, S extends CommonService<D>> implements InvocationHandler {

    private AbstractController<D, S> controller;

    public ControllerProxy(AbstractController<D, S> controller) {
        this.controller = controller;
    }

    public static <D extends AbstractDto, S extends CommonService<D>> AbstractController<D, S> newInstance(
            AbstractController<D, S> controller, Class<?> ...interf
    ) {
        return (AbstractController<D, S>) Proxy.newProxyInstance(
                controller.getClass().getClassLoader(),
                interf,
                new ControllerProxy<>(controller)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> declaringClass = method.getDeclaringClass();
        System.out.println(">>>" + controller.getClass().getSimpleName());
        return null;
    }
}
