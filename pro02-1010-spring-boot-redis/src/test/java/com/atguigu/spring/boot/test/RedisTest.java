package com.atguigu.spring.boot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @Test
    public void testSet() {
        SetOperations<String, String> operations = stringRedisTemplate.opsForSet();
        Set<String> animalSet = operations.members("animal");
        for (String animal : animalSet) {
            System.out.println("animal="+animal);
        }

    }

    @Test
    public void testStringRedisTemplate() {
        Set<String> keys = stringRedisTemplate.keys("*");
        for (String key : keys) {
            System.out.println("key="+key);
        }
    }

    @Test
    public void testRedisTemplate() {
        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
        operations.set("school", "atguigu");

        Object school = operations.get("school");
        System.out.println("school="+school);
    }

}
