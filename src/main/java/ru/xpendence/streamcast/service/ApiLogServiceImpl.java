package ru.xpendence.streamcast.service;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.xpendence.streamcast.attributes.StatusCode;
import ru.xpendence.streamcast.domain.ApiLog;
import ru.xpendence.streamcast.exception.ApiLogException;
import ru.xpendence.streamcast.repository.ApiLogRepository;
import ru.xpendence.streamcast.util.JsonUtils;

import java.util.Optional;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.11.2018
 * Time: 14:18
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Service
public class ApiLogServiceImpl implements ApiLogService {

    private final ApiLogRepository repository;

    @Autowired
    public ApiLogServiceImpl(ApiLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(ApiLog apiLog) {
        Optional.of(repository.save(apiLog))
                .orElseThrow(() -> new ApiLogException(
                        String.format(StatusCode.ERROR_SAVING_LOG.getDescription(), JsonUtils.toJson(apiLog))
                ));
    }

    @Override
    public ApiLog get(Long id) {
        return null;
    }

    @Override
    public Page<ApiLog> getAll(Predicate predicate, Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
