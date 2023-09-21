package com.bookstore.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookstore.bookstore.entity.User;

@Service
public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    User updateUser(Long id,User user);
    void deleteUser(Long id);
    User findByUsername(String username);

}
