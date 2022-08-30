package com.assismoraes.springsecurityjwt.repositories;

import com.assismoraes.springsecurityjwt.domain.RoleEnum;
import com.assismoraes.springsecurityjwt.domain.UserRole;
import com.assismoraes.springsecurityjwt.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserRepositoryImpl {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final UserRole userRoleSuperAdmin = new UserRole(1L, RoleEnum.SUPER_ADMIN.name());
    private final UserRole userRoleAdmin = new UserRole(2L, RoleEnum.ADMIN.name());
    private final UserRole userRoleManager = new UserRole(3L, RoleEnum.MANAGER.name());

    private final List<User> allUsers = Arrays.asList(
            new User(1L, "Joao", "joao", passwordEncoder.encode("1234"), List.of(userRoleAdmin, userRoleManager)),
            new User(1L, "Maria", "maria", passwordEncoder.encode("1234"), List.of(userRoleSuperAdmin)),
            new User(1L, "José", "jose", passwordEncoder.encode("1234"), List.of(userRoleManager)),
            new User(1L, "Carlos", "carlos", passwordEncoder.encode("1234"), List.of(userRoleAdmin))
    );

    public Optional<User> findByUsername(String username) {
        var list = allUsers.stream().filter(u -> u.getUsername().equals(username)).collect(Collectors.toList());
        if(!list.isEmpty()) {
            return Optional.of(list.get(0));
        }
        return null;
    }

}