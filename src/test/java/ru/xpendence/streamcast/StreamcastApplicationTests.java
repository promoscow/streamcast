package ru.xpendence.streamcast;

import com.google.common.collect.Lists;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.xpendence.streamcast.domain.QUser;
import ru.xpendence.streamcast.domain.User;
import ru.xpendence.streamcast.dto.UserDto;
import ru.xpendence.streamcast.dto.mapper.impl.UserMapper;
import ru.xpendence.streamcast.repository.UserRepository;
import ru.xpendence.streamcast.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamcastApplicationTests {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private UserService service;

	@Autowired
    private UserRepository repository;

	@Autowired
	private UserMapper mapper;

	@Test
	public void contextLoads() {
        UserDto dto = UserDto
				.builder()
				.id(1L)
				.active(1L)
				.created(LocalDateTime.now())
				.build();

		System.out.println(dto);
	}

	@Test
	public void fill() {
		for (int i = 0; i < 10; i++) {
			service.save(UserDto.builder().build());
		}
	}

	@Test
    @Transactional
	public void get() {

//	    UserDto u1 = service.get(1000000000L);
//        System.out.println(u1);

//		User user = new JPAQueryFactory(entityManager)
//                .selectFrom(QUser.user)
//                .where(QUser.user.id.eq(1000000000L))
//                .fetchOne();
//        System.out.println("->");
//        System.out.println(user.getId());
//
        QUser qUser = QUser.user;
        List<User> list = new JPAQueryFactory(entityManager)
                .selectFrom(qUser)
                .innerJoin(qUser.authors, qUser)
                .on(qUser.id.in(Lists.newArrayList(1000000001L)))
                .fetch();

        list.forEach(System.out::println);

//        User u2 = repository.getOne(1000000000L);
//        List<User> subscribers = u2.getSubscribers();
//        List<User> authors = u2.getAuthors();
//        System.out.println();
	}

}
