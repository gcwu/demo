//package org.demo.server.redis.impl;
//
//import java.util.Set;
//
//import javax.annotation.Resource;
//
//import org.demo.api.service.redis.RedisService;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.util.CollectionUtils;
//
//public class RedisServiceImpl implements RedisService {
//
//	@Resource
//	RedisTemplate<String, Object> redisTemplate;
//    /**
//     * @param key
//     */
//    public void del(final String... keys) {
//    	if(keys!=null && keys.length > 0){  
//            if(keys.length == 1){  
//                redisTemplate.delete(keys[0]);  
//            }else{  
//                redisTemplate.delete(CollectionUtils.arrayToList(keys));               
//            }  
//        }  
//    }
//	@Override
//	public void batchDel(String... keys) {
//		for (String kp : keys) {  
//            redisTemplate.delete(redisTemplate.keys(kp + "*"));  
//        }  
//	}
//	@Override
//	public Object getObject(String... key) {
//        return redisTemplate.opsForValue().get(key);  
//	}
//	@Override
//	public void set(String key, Object obj) {
//		redisTemplate.opsForValue().set(key, obj);
//	}
//	@Override
//	public Set<String> getByKeys(String pattern) {
//		 return redisTemplate.keys(pattern);
//	}
//
//}
