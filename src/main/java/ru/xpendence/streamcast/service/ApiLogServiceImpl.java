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
import ru.xpendence.streamcast.service.util.JsonMapper;

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
    private final JsonMapper jsonMapper;

    @Autowired
    public ApiLogServiceImpl(ApiLogRepository repository, JsonMapper jsonMapper) {
        this.repository = repository;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public void save(ApiLog apiLog) {
        Optional.of(repository.save(apiLog))
                .orElseThrow(() -> new ApiLogException(
                        String.format(StatusCode.ERROR_SAVING_LOG.getDescription(), jsonMapper.toJson(apiLog))
                ));
    }

    @Override
    public ApiLog get(Long id) {
        return null;
    }

    @Override
    public Page<ApiLog> getAll(Predicate predicate, Pageable pageable) {
        return repository.getAll(predicate, pageable);
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
