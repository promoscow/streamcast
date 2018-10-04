package ru.xpendence.streamcast;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.xpendence.streamcast.dto.UserDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamcastApplicationTests {

	@Test
	public void contextLoads() {
        UserDto dto = UserDto.builder().build();
	}

}
