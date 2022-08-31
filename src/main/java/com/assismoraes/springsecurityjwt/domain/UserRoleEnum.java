package com.assismoraes.springsecurityjwt.domain;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public enum UserRoleEnum {

    ADMIN(
            List.of(
                    UserPermissionEnum.READ_ADMIN_HOME,
                    UserPermissionEnum.READ_MANAGER_HOME
            )
    ),
    MANAGER(
            List.of(
                    UserPermissionEnum.READ_MANAGER_HOME
            )
    ),
    SUPER_ADMIN(
            List.of(
                    UserPermissionEnum.READ_SUPER_ADMIN_HOME,
                    UserPermissionEnum.READ_ADMIN_HOME,
                    UserPermissionEnum.READ_MANAGER_HOME
            )
    );

    public final List<GrantedAuthority> permissions;

    UserRoleEnum(List<GrantedAuthority> permissions) {
        this.permissions = permissions;
    }

}
