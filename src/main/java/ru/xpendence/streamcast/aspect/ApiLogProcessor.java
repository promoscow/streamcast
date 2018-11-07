package ru.xpendence.streamcast.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.xpendence.streamcast.dto.AbstractDto;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 07.11.18
 * Time: 21:54
 * e-mail: 2262288@gmail.com
 */
@Aspect
@Component
public class ApiLogProcessor<T extends AbstractDto> {

    @Before(value = "@annotation(request) && args(dto)")
    public void before(PostApiRequest request, T dto) {
        System.out.println();
    }
}
