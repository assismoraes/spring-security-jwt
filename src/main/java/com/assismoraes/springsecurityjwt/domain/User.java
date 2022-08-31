package com.assismoraes.springsecurityjwt.domain;

import com.assismoraes.springsecurityjwt.config.UserDetail;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class User {

    private Long id;

    private String name;

    private String username;

    private String password;

    private List<UserRoleEnum> userRoles;

    public User(Long id, String name, String username, String password, List<UserRoleEnum> userRoles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.userRoles = userRoles;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() { return password; }

    public List<UserRoleEnum> getRoles() { return userRoles; }

    public UserDetails toUserDetails() {
        return new UserDetail(this);
    }
}
