package com.assismoraes.springsecurityjwt.domain;

import org.springframework.security.core.GrantedAuthority;

public enum UserPermissionEnum implements GrantedAuthority {

    READ_MANAGER_HOME,
    READ_ADMIN_HOME,
    READ_SUPER_ADMIN_HOME;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
