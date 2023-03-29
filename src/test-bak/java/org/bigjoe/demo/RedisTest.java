package org.bigjoe.demo;

import org.bigjoe.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppMain.class)
public class RedisTest {
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void testObj() throws Exception {
		User user = new User();
		
		ValueOperations<String, User> operations = redisTemplate.opsForValue();
		operations.set("fdd2", user);
		
		boolean exists = redisTemplate.hasKey("fdd2");
		System.out.println("redis是否存在相应的key" + exists);
		
		User getUser = (User) redisTemplate.opsForValue().get("fdd2");
		System.out.println("从redis数据库获取的user:" + getUser.toString());
	}
}
