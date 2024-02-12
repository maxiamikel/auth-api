package com.maxi.authapi.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maxi.authapi.dtos.UserDto;
import com.maxi.authapi.services.UserServiceImplementation;

@RestController
@RequestMapping("/users")
public class AuthController {

    @Autowired
    private UserServiceImplementation userService;

    @GetMapping("")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok().body("First test testando");
    }

    @PostMapping("/save")
    public ResponseEntity<UserDto> save(@RequestBody UserDto user) {
        UserDto newUser = userService.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.login())
                .toUri();
        return ResponseEntity.created(uri).body(newUser);
    }
}
