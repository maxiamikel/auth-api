package com.maxi.authapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maxi.authapi.repositories.UserRepository;
import com.maxi.authapi.services.UserServiceImplementation;

@Configuration
public class AppConfig {

    @Bean
    public UserServiceImplementation userServiceImplementation(UserRepository userRepository) {
        return new UserServiceImplementation(userRepository);
    }

}
