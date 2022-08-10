package com.example.springbootsecuritybasic.service;

import com.example.springbootsecuritybasic.model.MyUser;
import com.example.springbootsecuritybasic.repository.MyUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private  final MyUserRepository myUserRepository;

    public MyUserDetailsService(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser=myUserRepository.findById(username).orElse(null);

        if (myUser == null) {
            return null;
        }
        return new User(myUser.userName(), myUser.passwordHash(), Collections.emptyList());
    }
}
