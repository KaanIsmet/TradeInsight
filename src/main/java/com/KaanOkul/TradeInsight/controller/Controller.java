package com.KaanOkul.TradeInsight.controller;


import com.KaanOkul.TradeInsight.entity.User;
import com.KaanOkul.TradeInsight.exceptionHandling.ResourceNotFound;
import com.KaanOkul.TradeInsight.repository.UserRepository;
import com.KaanOkul.TradeInsight.service.StockService;
import com.fasterxml.jackson.databind.JsonNode;
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

    @Autowired
    private StockService stockService;

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

    @GetMapping("/stocks/{symbol}/{function}/{interval}")
    public ResponseEntity<JsonNode> getStock(
            @PathVariable String symbol,
            @PathVariable String function,
            @PathVariable String interval
    ){
        //implement on getting a specific stock info and return a json if successful
        String url = stockService.getApiUrl();
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(url);
        strBuilder.append(function);
        strBuilder.append("&");


        return null; // placeholder
    }
}
