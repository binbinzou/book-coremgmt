package com.bookcase.system.bookcoremgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Application {
    public static void main( String[] args ){
    	SpringApplication.run(Application.class, args);
    }
}
