/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.service;

import com.example.example.data.User;
import com.example.example.data.UserRepository;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    public User setUser(String userName, MultipartFile userProfile, String contactNo, String email, String password, String userAddress, String roleType) throws IOException {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            return null;
        } else {
            this.passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);

            User user = new User();
            user.setUserName(userName);
            user.setUserProfile(userProfile.getBytes());
            user.setContactNo(contactNo);
            user.setEmail(email);
            user.setPassword(encodedPassword);
            user.setUserAddress(userAddress);
            user.setRoleType(roleType);
            return userRepository.save(user);
        }
    }

    public User updateUserById(String userName, MultipartFile userProfile, String contactNo, String email, String password, String userAddress, String roleType, int userId) throws IOException {
        User user = new User();
        if (userRepository.findById(userId).isPresent()) {
            this.passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);

            user.setUserName(userName);
            user.setUserProfile(userProfile.getBytes());
            user.setContactNo(contactNo);
            user.setEmail(email);
            user.setPassword(encodedPassword);
            user.setUserAddress(userAddress);
            user.setRoleType(roleType);
            user.setUserId(userId);
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public List<User> viewAllUsers() {
        return userRepository.findAll();
    }

    public List<User> viewAllUsersByRoleType(String roleType) {
        return userRepository.findAllByRoleType(roleType);
    }

    public Optional<User> viewAllUsersById(int userId) {
        return userRepository.findById(userId);
    }

    public void deleteUserById(int userId) {
        userRepository.deleteById(userId);
    }

    public Optional<User> userLogin(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {

            User user = optionalUser.get();
            this.passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return Optional.of(user);
            } else {
                return null;
            }

        } else {
            return null;
        }
    }
}
