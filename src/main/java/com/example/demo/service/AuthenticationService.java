package com.example.demo.service;

import com.example.demo.DTO.NewUserDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(NewUserDTO input) {
        User user = new User(
                input.getUsername(),
                passwordEncoder.encode(input.getPassword()),
                input.getEmail(),
                LocalDateTime.now().toString()
        );

        return userRepository.save(user);
    }

    public User authenticate(UserDTO input) {
        System.out.println(input.getEmail());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.getUserByEmail(input.getEmail())
                .orElseThrow();
    }
}