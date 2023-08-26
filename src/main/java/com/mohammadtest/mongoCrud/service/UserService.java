package com.mohammadtest.mongoCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mohammadtest.mongoCrud.model.User;
import com.mohammadtest.mongoCrud.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public void deleteById(@PathVariable("id") String id) {
        userRepository.deleteById(id);
    }
}
