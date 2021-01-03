01-Jedis[单独使用Jedis工具库在java代码中操作Redis数据库中的数据]
实现步骤
1.新建java project
2.导入jedis-2.9.0.jar
3.新建测试类
    1)创建Jedis对象
    2)调用Jedis对象的方法处理数据

注意事项:
    1) Jedis单独使用存在线程安全问题,需要配合commons-pool一同使用
    2) 通过网络访问Redis服务器出现Connect Time Out
        i.  修改redis.conf 关闭安全策略和绑定ip
        ii. 启动redis服务 ./redis-server ../redis.conf &
        iii.关闭Linux防火墙/让Redis的端口通过防火墙
    3) 通过网络访问Redis服务器出现NOAUTH
        i. 关闭Redis的访问密码[redis.conf配置文件]
        ii.jedis对象设置访问密码[jedis.auth("<password>");]