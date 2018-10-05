package ru.xpendence.streamcast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.xpendence.streamcast.domain.User;
import ru.xpendence.streamcast.dto.UserDto;
import ru.xpendence.streamcast.dto.mapper.impl.UserMapper;
import ru.xpendence.streamcast.service.UserService;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamcastApplicationTests {

	@Autowired
	private UserService service;

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
	public void get() {
		User user = mapper.convertToEntity(UserDto.builder().id(1000000000L).build());
		System.out.println(user);
		System.out.println(user.getAuthors());
		System.out.println();
	}

}
