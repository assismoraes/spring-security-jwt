package com.assismoraes.springsecurityjwt.config;

import com.assismoraes.springsecurityjwt.domain.User;
import com.assismoraes.springsecurityjwt.domain.UserRoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetail implements UserDetails {

    private String username;

    private String password;

    private List<GrantedAuthority> authorities = new ArrayList<>();

    public UserDetail(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        for (UserRoleEnum ur: user.getRoles()) {
            authorities.addAll(ur.permissions);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() { return password; }

    @Override
    public String getUsername() { return username; }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() { return true; }

}
