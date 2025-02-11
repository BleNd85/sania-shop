package com.example.saniashop.domain.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {

    ADMIN("ADMIN"),
    MANAGER("MANAGER"),
    USER("USER"),
    GUEST("GUEST");

    private final String roleName;
}
