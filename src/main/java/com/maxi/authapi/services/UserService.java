package com.maxi.authapi.services;

import java.util.Optional;

import com.maxi.authapi.dtos.UserDto;
import com.maxi.authapi.models.User;

public interface UserService {
    public UserDto save(UserDto userDto);

    public User findByLogin(String login);

    public Optional<User> findById(Long id);
}
