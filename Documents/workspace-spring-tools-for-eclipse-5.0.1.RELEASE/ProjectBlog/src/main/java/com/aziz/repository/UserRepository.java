package com.aziz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aziz.model.User;

public interface UserRepository extends MongoRepository<User,String> {
User findByUsername(String username);
User findBy(String email);
}
