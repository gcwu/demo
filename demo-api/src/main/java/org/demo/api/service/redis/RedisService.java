package org.demo.api.service.redis;

import java.util.Set;
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
     * @param key
     */
    public abstract void del(String... keys);
    /** 
     * 批量删除<br> 
     * （该操作会执行模糊查询，请尽量不要使用，以免影响性能或误删） 
     * @param pattern 
     */   
    public abstract void batchDel(String... keys);
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
    public abstract void  set(String key,Object obj);
    
    /** 
     * 模糊查询keys 
     * @param pattern 
     * @return 
     */  
    public abstract Set<String> getByKeys(String pattern);
}
