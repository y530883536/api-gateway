package com.ycf.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //set还有其它一些方法是没有返回值的，只能用异常判断来检查是否设置成功了
    public boolean set(String key,String value) {
        try {
            stringRedisTemplate.opsForValue().set(key,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String get(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return value;
    }

    public boolean zadd(String key,String value,double score) {
        try {
            return stringRedisTemplate.opsForZSet().add(key, value, score);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Set<String> zrange(String key,int startIndex,int endIndex) {
        Set<String> resultSet = stringRedisTemplate.opsForZSet().range(key, startIndex, endIndex);
        return resultSet;
    }

}
