package ru.xpendence.streamcast.repository;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ru.xpendence.streamcast.domain.Message;
import ru.xpendence.streamcast.domain.QMessage;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.09.18
 * Time: 22:43
 * e-mail: 2262288@gmail.com
 */
@Repository
public interface MessageRepository extends RepositoryCustom<Message, QMessage, Long> {

    Page<Message> getAll(Predicate predicate, Pageable pageable);
}
