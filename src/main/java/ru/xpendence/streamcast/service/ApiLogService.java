package ru.xpendence.streamcast.service;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.xpendence.streamcast.domain.ApiLog;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.11.2018
 * Time: 14:15
 * e-mail: 2262288@gmail.com
 */
public interface ApiLogService {

    void save(ApiLog apiLog);

    ApiLog get(Long id);

    Page<ApiLog> getAll(Predicate predicate, Pageable pageable);

    Boolean delete(Long id);
}
