package com.wizeline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wizeline.dto.UserDto;
import com.wizeline.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/{id}")
    private UserDto getUsers (@PathVariable Long id) {
        return userService.getUser(id);
    }
}
