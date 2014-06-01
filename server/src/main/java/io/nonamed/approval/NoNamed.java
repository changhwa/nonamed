package io.nonamed.approval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class NoNamed {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(NoNamed.class, args);
    }
}
