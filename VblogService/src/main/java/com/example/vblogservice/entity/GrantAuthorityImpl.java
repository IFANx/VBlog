package com.example.vblogservice.entity;

import org.springframework.security.core.GrantedAuthority;

public class GrantAuthorityImpl implements GrantedAuthority {
    private String authority;

    public GrantAuthorityImpl(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
