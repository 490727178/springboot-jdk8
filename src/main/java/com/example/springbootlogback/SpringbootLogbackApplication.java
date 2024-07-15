package com.example.springbootlogback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@SpringBootApplication
public class SpringbootLogbackApplication {

    public static void main(String[] args) {
//        log.debug("启动之前 - Springboot默认Debug级别");
        SpringApplication.run(SpringbootLogbackApplication.class, args);
//        log.info("启动之后  {}","Logback配置生效，所以输出Info日志");
    }

    @GetMapping("test")
    public String generateString() {
        return "Hello, this is the specified string.";
    }

}
