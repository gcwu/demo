package org.demo.server;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:conf/redis-context.xml"})
public class TestRedis {
	@Autowired
	RedisTemplate<String, String> redisTemplate;
	@Test  
    public void testSpringRedis() {  
		//保存到redis
		redisTemplate.opsForValue().set("name","gcwu");
		//从redis中获取
		String name = redisTemplate.opsForValue().get("name");
		System.out.println(name);
    }  
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.222.129", 6379);
		jedis.auth("123456");
		//jedis.set("age", "1000");
        System.out.println(jedis.get("age"));
    }
}

