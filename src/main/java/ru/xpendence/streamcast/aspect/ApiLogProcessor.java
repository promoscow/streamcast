package ru.xpendence.streamcast.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.xpendence.streamcast.attributes.TransferType;
import ru.xpendence.streamcast.domain.ApiLog;
import ru.xpendence.streamcast.service.ApiLogService;
import ru.xpendence.streamcast.service.util.JsonMapper;

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

    private final ApplicationContext context;
    private final ApiLogService service;
    private final JsonMapper jsonMapper;

    @Autowired
    public ApiLogProcessor(ApiLogService service, ApplicationContext context, JsonMapper jsonMapper) {
        this.service = service;
        this.context = context;
        this.jsonMapper = jsonMapper;
    }

    @Before(value = "@annotation(request) && args(dto)")
    public void before(PostApiRequest request, Object dto) {
        service.save(ApiLog.of(
                LocalDateTime.now(),
                TransferType.REQUEST.name(),
                HttpMethod.POST.name(),
                getPath(dto),
                jsonMapper.toJson(dto)
        ));
    }

    // FIXME: 11.11.18 найти способ переделать этот пиздец
    private String getPath(Object dto) {
        String value = null;
        try {
            String bean = dto.getClass().getSimpleName().replace("Dto", "Controller");
            String firstToReplace = String.valueOf(bean.charAt(0));
            String controllerName = bean.replaceFirst(firstToReplace, firstToReplace.toLowerCase());
            value = Class.forName(context.getBeansWithAnnotation(RequestMapping.class)
                    .get(controllerName).toString().replaceAll("(@).+", ""))
                    .getAnnotation(RequestMapping.class)
                    .value()[0];
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }
}
