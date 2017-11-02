package org.demo.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.JedisCluster;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath:conf/spring-mybatis.xml"})
public class TestRedis {
//	@Autowired
//	RedisTemplate<String, String> redisTemplate;
	@Autowired
	JedisCluster jedisCluster;
	@Test  
    public void testSpringRedis() {  
//		//保存到redis
//		redisTemplate.opsForValue().set("name","gcwu");
//		//从redis中获取
//		String name = redisTemplate.opsForValue().get("name");
//		System.out.println(name);
		System.out.println("-----开始----");
		jedisCluster.setnx("wu", "12344");
		jedisCluster.set("1111", "123123123");
		System.out.println(jedisCluster.get("wu"));;
		System.out.println("-----结束----");
    }  
	
}

