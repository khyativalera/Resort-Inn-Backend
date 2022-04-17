package com.example.restInn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.restInn.entity.Users;

@Repository
public interface UserDao extends MongoRepository<Users, String> {

    Users findByUserName(String userName);

}
