package com.assismoraes.springsecurityjwt.domain;

import com.assismoraes.springsecurityjwt.config.UserDetail;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class User {

    private Long id;

    private String name;

    private String username;

    private String password;

    private List<UserRole> userRoles;

    public User(Long id, String name, String username, String password, List<UserRole> userRoles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.userRoles = userRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRole> getRoles() { return userRoles; }

    public void setRoles(List<UserRole> userRoles) { this.userRoles = userRoles; }

    public UserDetails toUserDetails() {
        return new UserDetail(this);
    }
}
