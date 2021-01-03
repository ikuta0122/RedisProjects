package com.ikuta.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
    private static JedisPool pool;

    //创建JedisPool对象
    public static JedisPool open(String host, int port) {
        if (pool == null) {
            //1.创建JedisPoolConfig对象
            JedisPoolConfig config = new JedisPoolConfig();

            //2.设置JedisPoolConfig对象的连接池参数
            //设置最大线程数,一个线程代表一个Jedis对象
            config.setMaxTotal(20);
            //设置最大空闲数
            config.setMaxIdle(2);
            //设置检查项为true,表示从线程池获取的Jedis对象一定是经过检查可用的
            config.setTestOnBorrow(true);

            //3.创建JedisPool对象,使用JedisPoolConfig对象作为参数
            pool = new JedisPool(config, host, port,6000);
        }
        return pool;
    }
    //关闭JedisPool对象
    public static void close(){
        if (pool != null){
            pool.close();
        }
    }
}
