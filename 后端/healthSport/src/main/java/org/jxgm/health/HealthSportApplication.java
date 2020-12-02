package org.jxgm.health;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.jxgm.health.dao")
public class HealthSportApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthSportApplication.class, args);
    }

}
