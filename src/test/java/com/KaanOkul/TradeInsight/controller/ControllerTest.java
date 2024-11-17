package com.KaanOkul.TradeInsight.controller;

import com.KaanOkul.TradeInsight.entity.User;
import com.KaanOkul.TradeInsight.repository.UserRepository;
import com.KaanOkul.TradeInsight.service.StockService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = Controller.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private StockService stockService;

    @Test
    void testGetAllUserStatusOk() throws Exception {
        mockMvc.perform(get("/api/v1/users"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetUserById() throws Exception {
        // Mock a User object
        User user = new User(4,"JohnDoe", "John Doe", "JohnDoe123", "john.doe@example.com", "USER", true);
        when(userRepository.findById(4)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/v1/users/4"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("john.doe@example.com"));
    }

    @Test
    void testGetUserById_NotFound() throws Exception {
        when(userRepository.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/users/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void createUser() throws Exception {
        User user = new User(5, "JohnSmith", "John Smith", "JohnSmith123", "john.smith@example.com", "USER", true);
        User savedUser = new User(5, "JohnSmith", "John Smith", "JohnSmith123", "john.smith@example.com", "USER", true);

        // Mock the save method in the repository
        when(userRepository.save(user)).thenReturn(savedUser);


        // Convert the User object to JSON
        String userJson = new ObjectMapper().writeValueAsString(user);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/users")
                .content(userJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andDo(result -> {
                    System.out.println("Response Status: " + result.getResponse().getStatus());  // Debugging
                    System.out.println("Response Body: " + result.getResponse().getContentAsString());  // Debugging
                });


    }

}
