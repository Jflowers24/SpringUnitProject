package com.example.demo.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ControllerConfig {

    @Bean
    CommandLineRunner commandLineRunner4(
            ControllerRepository Repository){
        return args -> {
            Controller XboxController = new Controller(
                    "XboxController"

            );
            Controller JoyCon1 = new Controller(
                    "Joycon1"
            );
            Controller Rose = new Controller(
                    "Rose"
            );
            Controller ProController = new Controller(
                    "Pro Controller"
            );
            Controller PlaystationController = new Controller(
                    "Playstation Controller"
            );
            Controller JoyCon2 = new Controller(
                    "Joycon2"
            );
            Repository.saveAll(List.of(XboxController, JoyCon2, JoyCon1, PlaystationController, Rose, ProController));


        };
    }

}

