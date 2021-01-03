02-CommonsPool[Jedis和CommonsPool的联合使用,实现在java代码中操作Redis数据库中的数据]
实现步骤
1.新建java project
2.导入jar包
    jedis-2.9.0.jar
    commons-pool2-2.4.2.jar
3.新建工具类[提供两个静态方法]
    1)创建JedisPool对象的方法
        i.  创建JedisPoolConfig对象
        ii. 设置JedisPoolConfig对象的连接池参数[最大线程数,最大空闲数,线程检查项]
        iii.使用JedisPoolConfig对象作为参数创建JedisPool对象
    2)关闭JedisPool对象的方法
4.新建测试类
    1)创建JedisPool对象
    2)从JedisPool对象中获取Jedis对象
    3)调用Jedis对象的方法处理数据
    4)关闭Jedis对象,即将该Jedis对象放回JedisPool中以供其他请求使用

注意事项:
    1) Jedis单独使用存在线程安全问题,需要配合commons-pool一同使用
    2) 通过网络访问Redis服务器出现Connect Time Out
        i.  修改redis.conf 关闭安全策略和绑定ip
        ii. 启动redis服务 ./redis-server ../redis.conf &
        iii.关闭Linux防火墙/让Redis的端口通过防火墙
    3) 通过网络访问Redis服务器出现NOAUTH
        i. 关闭Redis的访问密码[redis.conf配置文件]
        ii.jedis对象设置访问密码[jedis.auth("<password>");]