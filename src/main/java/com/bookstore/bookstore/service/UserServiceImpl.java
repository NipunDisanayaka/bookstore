package com.bookstore.bookstore.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
     return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found : "+id));
    }

    @Override
    public User saveUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
      User existingUser = getUserById(id);

      existingUser.setUsername(user.getUsername());
      existingUser.setEmail(user.getEmail());
      existingUser.setPassword(user.getPassword());

      return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
       userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
     return userRepository.findByUsername(username);
    }
    
}
