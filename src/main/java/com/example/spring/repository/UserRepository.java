package com.example.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.dao.UserDAO;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Long> {
  UserDAO findUserByEmail(String email);

  List<UserDAO> findUsersByName(String name);
}
