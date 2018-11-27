package org.plat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ReptileJsoupGatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReptileJsoupGatherApplication.class, args);
    }
}
