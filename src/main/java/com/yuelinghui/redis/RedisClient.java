package com.yuelinghui.redis;

import org.crazycake.shiro.BaseRedisManager;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * redis 管理工具
 * @author xla
 */
public class RedisClient extends BaseRedisManager {

    private JedisPool jedisPool;

    private int expire;


    public RedisClient(JedisPool jedisPool, int expire) {
        this.jedisPool = jedisPool;
        this.expire = expire;
    }

    @Override
    protected Jedis getJedis() {
        return jedisPool.getResource();
    }

}
