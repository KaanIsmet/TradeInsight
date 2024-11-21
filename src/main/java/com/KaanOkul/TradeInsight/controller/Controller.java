package com.KaanOkul.TradeInsight.controller;


import com.KaanOkul.TradeInsight.entity.User;
import com.KaanOkul.TradeInsight.exceptionHandling.ResourceNotFound;
import com.KaanOkul.TradeInsight.repository.UserRepository;
import com.KaanOkul.TradeInsight.service.ApiBuilder;
import com.KaanOkul.TradeInsight.service.StockService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
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
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("users/validate")
    public ResponseEntity<?> validateCredential(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return ResponseEntity.ok(Map.of("message", "Login Successful"));
        }
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Invalid Credentials"));
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
        ApiBuilder builder = new ApiBuilder();
        //implement on getting a specific stock info and return a json if successful
        String url = builder.build(stockService.getApiUrl(),symbol, function, interval, stockService.getApiKey());
        System.out.println(url);

        return stockService.getStockData(url);

    }
}
