package com.example.springbootsecuritybasic.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api/users")
public class UserController {


    @GetMapping("login")
    public String login(){

        return me();
    }

    @GetMapping("me")
    String me(){
        return ((User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()).getUsername();



    }

    @GetMapping("logout")
    void logout(HttpSession session){
        session.invalidate();
    }
}
