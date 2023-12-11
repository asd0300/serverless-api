package dev.benfan.models;

import org.springframework.security.core.GrantedAuthority;

public enum UserAuthority implements GrantedAuthority {
    ADMIN,
    NORMAL,
    GUEST;

    @Override
    public String getAuthority() {
        return name();
    }
}
