package com.KaanOkul.TradeInsight.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "username")
    private String username;

    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "enabled")
    private boolean enabled;

    public User() {}

    public User(Integer id, String username, String name, String password, String email, String role, boolean enabled) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {return role; }

    public void setRole(String role) {this.role = role; }

    public boolean isEnabled() {return enabled; }

    public void setEnabled(boolean enabled) {this.enabled = enabled; }
}
