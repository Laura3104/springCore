package com.example.spring.service;

import com.example.spring.dao.UserDAO;
import com.example.spring.exception.NonExistentUserException;
import com.example.spring.model.DTO.User;
import com.example.spring.model.UserI;
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
        log.info("Getting User");
        return userRepository.findById(userId).orElseThrow(NonExistentUserException::new);
    }


    public UserI getUserByEmail(String email) {
        return null;
    }


    public List<UserI> getUsersByName(String name, int pageSize, int pageNum) {
        return null;
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
