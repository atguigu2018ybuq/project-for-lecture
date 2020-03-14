package com.atguigu.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

public class JedisTest {

    // 访问Redis的IP地址
    private String ipAddress = "192.168.19.88";

    // 访问Redis的端口号
    private int port = Protocol.DEFAULT_PORT;

    @Test
    public void test001() {
        System.out.println("hello git...");
    }

    @Test
    public void testJedisPool() {
        // 1.创建JedisPool对象
        JedisPool jedisPool = new JedisPool(ipAddress, port);

        // 2.从连接池对象获取Jedis对象
        Jedis jedis = jedisPool.getResource();

        // 3.Jedis用法不变
        String salary = jedis.get("salary");

        System.out.println("salary="+salary);
    }

    @Test
    public void testJedis() {

        // 1.创建Jedis对象
        Jedis jedis = new Jedis(ipAddress, port);

        // 2.调用和Redis命令同名的方法即可
        String pingResult = jedis.ping();

        System.out.println("pingResult="+pingResult);

    }

}
