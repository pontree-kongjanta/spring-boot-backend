package com.example.training.myApp4.repository;

import com.example.training.myApp4.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    Optional<User> findByEmail(String  email);
}
