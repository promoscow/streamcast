package ru.xpendence.streamcast.repository;

import org.springframework.stereotype.Repository;
import ru.xpendence.streamcast.domain.QUserDetails;
import ru.xpendence.streamcast.domain.UserDetails;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 16.11.2018
 * Time: 11:43
 * e-mail: vyacheslav.chernyshov@stoloto.ru
 */
@Repository
public interface UserDetailsRepository extends RepositoryCustom<UserDetails, QUserDetails, Long> {
}
