package com.mohammadtest.mongoCrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mohammadtest.mongoCrud.model.User;
import com.mohammadtest.mongoCrud.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*")
    @PostMapping("/users")
    public ResponseEntity<User> save(@Validated @RequestBody User user, BindingResult bindingResult) {
        try {
            User user2 = userService.findByUsername(user.getUsername());
            if (user2 != null) {
                return new ResponseEntity<User>(user2, HttpStatus.CONFLICT);
            }
            User _user = userService.createUser(user);
            return new ResponseEntity<User>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/users/login")
    public ResponseEntity<User> userLogin(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        try {
            User user2 = userService.findByUsername(username);
            if (user2 == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user2);
            } else if (!user2.getPassword().equals(password)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user2);
            }
            return ResponseEntity.status(HttpStatus.OK).body(user2);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        Optional<User> optional = userService.findById(id);
        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateOne(@PathVariable("id") String id, @RequestBody User user) {
        Optional<User> optional = userService.findById(id);

        if (optional.isPresent()) {
            User _user = optional.get();
            _user.setUsername(user.getUsername());
            _user.setEmail(user.getEmail());
            _user.setPhone(user.getPhone());
            _user.setPassword(user.getPassword());
            return new ResponseEntity<>(userService.createUser(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String id) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
