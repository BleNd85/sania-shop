package com.example.saniashop.domain.user;

import com.example.saniashop.domain.cart.Cart;
import com.example.saniashop.domain.common.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class User {

    private UUID id;

    private String email;

    private String password;

    private String name;

    private String secondName;

    private Timestamp registrationDate;

    private List<Role> roles;

    private Cart cart;

}

