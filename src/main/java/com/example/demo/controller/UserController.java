package com.example.demo.controller;

import com.example.demo.DTO.LoginResponse;
import com.example.demo.DTO.NewUserDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.converter.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private final UserMapper UserMapper;
    @Autowired
    public UserController(
            JwtService jwtService,
            AuthenticationService authenticationService,
            UserMapper userMapper
    ) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.UserMapper = userMapper;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> register(@RequestBody NewUserDTO newUserDTO) {
        User registeredUser = authenticationService.signup(newUserDTO);
        UserDTO userDTO = UserMapper.mapToDTO(registeredUser);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody UserDTO userDTO) {
        User authenticatedUser = authenticationService.authenticate(userDTO);

        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse(
                jwtToken,
                jwtService.getExpirationTime(),
                authenticatedUser.getEmail(),
                authenticatedUser.getUserId()
        );

        return ResponseEntity.ok(loginResponse);
    }
}
