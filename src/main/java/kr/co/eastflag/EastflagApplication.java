package kr.co.eastflag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EastflagApplication {

    // https://daddyprogrammer.org/post/4731/spring-websocket-chatting-server-redis-pub-sub/
    public static void main(String[] args) {
        SpringApplication.run(EastflagApplication.class, args);
    }
}
