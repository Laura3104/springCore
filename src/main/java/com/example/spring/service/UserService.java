package com.example.spring.service;

import com.example.spring.dao.UserDAO;
import com.example.spring.exception.NonExistentUserException;
import com.example.spring.model.dto.User;
import com.example.spring.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDAO getUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(NonExistentUserException::new);
    }


    public UserDAO getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }


    public List<UserDAO> getUsersByName(String name) {
        return userRepository.findUsersByName(name);
    }


    public UserDAO createUser(User user) {

        UserDAO userDAO = new UserDAO();
        userDAO.setName(user.getName());
        userDAO.setEmail(user.getEmail());

        return userRepository.save(userDAO);
    }


    public UserDAO updateUser(User user) {

        UserDAO userToUpdate = getUserById(user.getId());
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());

        return userRepository.save(userToUpdate);
    }


    public void deleteUser(long userId) {
        UserDAO userToDelete = getUserById(userId);
        userRepository.deleteById(userToDelete.getId());
    }

}
