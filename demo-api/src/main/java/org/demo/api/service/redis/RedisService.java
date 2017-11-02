package org.demo.api.service.redis;

/**
 * redis 的操作开放接口
 * 
 * @author gcwu
 * 
 */
public interface RedisService {
	/**
     * 通过key删除
     * 
     * @param keys
     */
    public abstract void del(String... keys);
    
    /**
     * 通过key删除
     * 
     * @param key
     */
    public abstract Long delByKey(String key);
   
    /** 
     * 取得缓存
     * @param key 
     * @return 
     */  
    public abstract Object  getObject(String... key);
    
    /**
     * 保存
     * @param key
     */
    public abstract void  set(String key,String obj);
    
    /** 
     * 查询keys 
     * @param pattern 
     * @return 
     */  
    public abstract String getByKey(String key);
}
