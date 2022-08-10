package com.example.springbootsecuritybasic.service;

import com.example.springbootsecuritybasic.model.MyUser;
import com.example.springbootsecuritybasic.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    MyUserRepository myUserRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {



        MyUser myUser=new MyUser("frank", passwordEncoder.encode("frank123"));
        myUserRepository.save(myUser);
        MyUser i=myUserRepository.findById("frank").orElse(null);
        System.out.println("my user from db" +i);
    }
}
