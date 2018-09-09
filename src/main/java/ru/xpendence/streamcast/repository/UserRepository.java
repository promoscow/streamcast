package ru.xpendence.streamcast.repository;

import org.springframework.stereotype.Repository;
import ru.xpendence.streamcast.domain.QUser;
import ru.xpendence.streamcast.domain.User;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.09.18
 * Time: 22:42
 * e-mail: 2262288@gmail.com
 */
@Repository
public interface UserRepository extends RepositoryCustom<User, QUser, Long> {
}
