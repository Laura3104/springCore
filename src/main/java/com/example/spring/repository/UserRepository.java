package com.example.spring.repository;

import com.example.spring.dao.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserDAO, Long> {
    UserDAO findUserByEmail(String email);
    List<UserDAO> findUsersByName(String name);
    
}
