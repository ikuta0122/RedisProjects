package com.ikuta.redis;

import redis.clients.jedis.Jedis;

public class RedisString {
    public static void main(String[] args) {
        //指定连接的Redis服务器IP
        String host = "192.168.253.128";
        //指定连接的Redis服务器端口
        int port = 6379;
        //创建Jedis对象
        Jedis jedis = new Jedis(host, port);

        //注意:访问Redis服务器需要设置访问密码
        //jedis.auth("password");

        //调用Jedis对象的方法处理数据
        jedis.set("idol", "西野七濑");
        String value = jedis.get("idol");
        System.out.println("idol = " + value);
    }
}
