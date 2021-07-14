package io.javabrains.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//tells Spring boot to start the application CourseApiApp and create servlet container and host the app in servlet container
@SpringBootApplication
public class CourseApiApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication.run(CourseApiApp.class, args);
    }
}
