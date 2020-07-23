package kr.co.eastflag.websocket;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.listener.ChannelTopic;

@SpringBootTest
class ApiserverApplicationTests {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

//    @Test
    void test1() {
        //hashmap같은 key value 구조
        ValueOperations<String, Object> vop = redisTemplate.opsForValue();
        vop.set("jdkSerial", "jdk");
        String result = (String) vop.get("jdkSerial");
        System.out.println(result);//jdk
    }

    @Test
    public void publishTest() {
        redisTemplate.convertAndSend("channel1", "test message");
    }
}
