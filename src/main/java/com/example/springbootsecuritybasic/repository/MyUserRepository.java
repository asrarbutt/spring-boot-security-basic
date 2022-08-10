package com.example.springbootsecuritybasic.repository;

import com.example.springbootsecuritybasic.model.MyUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface MyUserRepository extends MongoRepository<MyUser, String> {
}
