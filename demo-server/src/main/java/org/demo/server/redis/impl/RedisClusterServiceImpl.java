package org.demo.server.redis.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.demo.api.service.redis.RedisService;

import com.alibaba.dubbo.config.annotation.Service;

import redis.clients.jedis.JedisCluster;
@Service
public class RedisClusterServiceImpl implements RedisService {
	@Resource
	JedisCluster jedisCluster;
	@Override
	public void del(String... keys) {
		jedisCluster.del(keys);
	}


	@Override
	public Object getObject(String... key) {
		return jedisCluster.mget(key);
	}

	@Override
	public void set(String key, String obj) {
		jedisCluster.set(key, obj);
	}

	@Override
	public String getByKey(String key) {
		return jedisCluster.get(key);
	}


	@Override
	public Long  delByKey(String key) {
		return  jedisCluster.del(key);
	}

	

}
