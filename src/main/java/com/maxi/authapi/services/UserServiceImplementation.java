package com.maxi.authapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.maxi.authapi.dtos.UserDto;
import com.maxi.authapi.models.User;
import com.maxi.authapi.repositories.UserRepository;

public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto userDto) {

        User existUser = this.findByLogin(userDto.login());
        if (existUser != null) {
            throw new RuntimeException("User login is taken");
        }
        String passwordHash = bCryptPasswordEncoder.encode(userDto.pwd());
        User user = new User(userDto.name(), userDto.login(), passwordHash);
        User newUser = userRepository.save(user);
        return new UserDto(newUser.getName(), newUser.getLogin(), newUser.getPwd());
    }

    @Override
    public User findByLogin(String login) {
        User userLogin = userRepository.findByLogin(login);
        if (userLogin != null) {
            return userLogin;
        }
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user;
        }
        return null;
    }

}
