package com.maxi.authapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.authapi.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByLogin(String login);

    public Optional<User> findById(Long id);
}