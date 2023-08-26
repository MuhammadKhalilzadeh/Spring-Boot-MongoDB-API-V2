package com.mohammadtest.mongoCrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mohammadtest.mongoCrud.model.User;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByUsername(String username);
}
