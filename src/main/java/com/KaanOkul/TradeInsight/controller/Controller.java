package com.KaanOkul.TradeInsight.controller;


import com.KaanOkul.TradeInsight.entity.User;
import com.KaanOkul.TradeInsight.exceptionHandling.ResourceNotFound;
import com.KaanOkul.TradeInsight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class Controller {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("User could not be found with id:" + id)
        );
        return ResponseEntity.ok(user);
    }
}
