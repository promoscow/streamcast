package ru.xpendence.streamcast.repository;

import com.querydsl.core.types.dsl.EntityPathBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.NoRepositoryBean;
import ru.xpendence.streamcast.domain.AbstractEntity;

import java.io.Serializable;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 08.09.18
 * Time: 22:00
 * e-mail: 2262288@gmail.com
 */
@NoRepositoryBean
public interface RepositoryCustom<
        T extends AbstractEntity,
        P extends EntityPathBase<T>,
        ID extends Serializable>
        extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T>, QuerydslBinderCustomizer<P> {

    @Override
    default void customize(QuerydslBindings bindings, P root) {
    }
}
