package com.ikuta.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisString {
    public static void main(String[] args) {
        JedisPool pool;
        Jedis jedis = null;
        String host = "192.168.253.128";
        int port = 6379;
        try {
            //1.创建JedisPool对象
            pool = RedisUtils.open(host, port);
            //2.从JedisPool对象中获取Jedis对象
            jedis = pool.getResource();
            //3.调用Jedis对象的方法处理数据
            jedis.set("idol", "生田绘梨花");
            String value = jedis.get("idol");
            System.out.println("idol = " + value);
        } finally {
            //4.关闭Jedis对象,即将该Jedis对象放回JedisPool中以供其他请求使用
            if (jedis != null) {
                jedis.close();
            }
        }


    }
}
