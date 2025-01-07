package com.example.demo.configuration;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerForUser(UserRepository repository) {
        return args -> {
            User firstUser = new User(
                    "testEmail",
                    "testPassword",
                    "testEmail@gmail.com",
                    LocalDateTime.now().toString()
            );

            repository.save(firstUser);
        };
    }
}
