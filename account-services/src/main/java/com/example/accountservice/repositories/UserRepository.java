package com.example.accountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.accountservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

}
