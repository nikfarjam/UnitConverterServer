package com.mehdi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class UnitConverterApplication {

    private static final Logger logger = LogManager.getLogger(UnitConverterApplication.class.getName());

    public static void main(String[] args) {
        logger.debug("Start Application");
        SpringApplication.run(UnitConverterApplication.class, args);
    }
}
