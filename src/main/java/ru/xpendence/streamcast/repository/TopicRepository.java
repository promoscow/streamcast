package ru.xpendence.streamcast.repository;

import org.springframework.stereotype.Repository;
import ru.xpendence.streamcast.domain.QTopic;
import ru.xpendence.streamcast.domain.Topic;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.09.18
 * Time: 22:43
 * e-mail: 2262288@gmail.com
 */
@Repository
public interface TopicRepository extends RepositoryCustom<Topic, QTopic, Long> {
}
