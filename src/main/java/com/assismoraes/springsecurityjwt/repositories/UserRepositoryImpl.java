package com.assismoraes.springsecurityjwt.repositories;

import com.assismoraes.springsecurityjwt.domain.User;
import com.assismoraes.springsecurityjwt.domain.UserRoleEnum;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserRepositoryImpl {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final List<User> allUsers = Arrays.asList(
            new User(1L, "Joao", "joao", passwordEncoder.encode("1234"), List.of(UserRoleEnum.ADMIN, UserRoleEnum.MANAGER)),
            new User(1L, "Maria", "maria", passwordEncoder.encode("1234"), List.of(UserRoleEnum.SUPER_ADMIN)),
            new User(1L, "José", "jose", passwordEncoder.encode("1234"), List.of(UserRoleEnum.MANAGER)),
            new User(1L, "Carlos", "carlos", passwordEncoder.encode("1234"), List.of(UserRoleEnum.ADMIN))
    );

    public Optional<User> findByUsername(String username) {
        var list = allUsers.stream().filter(u -> u.getUsername().equals(username)).collect(Collectors.toList());
        return Optional.ofNullable(!list.isEmpty() ? list.get(0) : null);
    }

}