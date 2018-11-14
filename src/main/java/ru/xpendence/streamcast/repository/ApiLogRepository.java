package ru.xpendence.streamcast.repository;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ru.xpendence.streamcast.domain.ApiLog;
import ru.xpendence.streamcast.domain.QApiLog;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.11.2018
 * Time: 14:13
 * e-mail: 2262288@gmail.com
 */
@Repository
public interface ApiLogRepository extends RepositoryCustom<ApiLog, QApiLog, Long> {

    List<ApiLog> getAll(Predicate predicate, Pageable pageable);
}
