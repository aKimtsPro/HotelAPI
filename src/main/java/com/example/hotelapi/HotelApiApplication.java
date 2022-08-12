package com.example.hotelapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HotelApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelApiApplication.class, args);
    }


    @Bean
    public String salut(){
        return "salut";
    }

}
