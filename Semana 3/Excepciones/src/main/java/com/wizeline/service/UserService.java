package com.wizeline.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wizeline.dto.UserDto;
import com.wizeline.entity.User;
import com.wizeline.exception.UserNotFoundException;
import com.wizeline.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public UserDto getUser(long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }

        User user = optionalUser.get();
        return UserDto
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail()).build();
    }

}
