package com.example.demo.converter;

import com.example.demo.DTO.NewUserDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class UserMapper {
    public User mapToEntity(NewUserDTO newUserDTO) {
        User user = new User();
        user.setUsername(newUserDTO.getUsername());
        user.setPassword(newUserDTO.getPassword());
        user.setEmail(newUserDTO.getEmail());
        user.setCreatedAt(LocalDateTime.now().toString());
        return user;
    }

    public UserDTO mapToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setCreatedAt(user.getCreatedAt());
        return userDTO;
    }
}
