package com.prathish.runners;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
public class RunnersApplication {

    private static final Logger log = getLogger(RunnersApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(RunnersApplication.class, args);
        log.info("Something changed")   ;
    }

}
