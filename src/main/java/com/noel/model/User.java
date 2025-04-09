package com.noel.model;

import lombok.Data;

@Data
public class User {
    private String login;
    private String password;
    private String phone;
    private String email;

    private Profile profile;
}
