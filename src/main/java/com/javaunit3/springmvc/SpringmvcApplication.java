package com.javaunit3.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

//annotate with SpringBootApplication
@SpringBootApplication
public class SpringmvcApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringmvcApplication.class, args);
    }
}
