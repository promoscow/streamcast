package ru.xpendence.streamcast.repository;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ru.xpendence.streamcast.domain.QTopic;
import ru.xpendence.streamcast.domain.Topic;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.09.18
 * Time: 22:43
 * e-mail: 2262288@gmail.com
 */
@Repository
public interface TopicRepository extends RepositoryCustom<Topic, QTopic, Long> {

    List<Topic> getAll(Predicate predicate, Pageable pageable);
}
