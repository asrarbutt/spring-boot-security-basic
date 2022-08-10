package com.example.springbootsecuritybasic.model;

import org.springframework.data.annotation.Id;

public record MyUser (
        @Id
        String userName,
        String passwordHash
){

}
