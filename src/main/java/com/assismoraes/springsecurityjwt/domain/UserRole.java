package com.assismoraes.springsecurityjwt.domain;

import org.springframework.security.core.GrantedAuthority;

public class UserRole implements GrantedAuthority {

    private Long id;

    private String name;

    public UserRole(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getAuthority() { return name; }
}
