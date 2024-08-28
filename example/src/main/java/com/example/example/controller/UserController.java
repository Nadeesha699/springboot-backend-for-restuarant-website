/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.controller;

import com.example.example.data.User;
import com.example.example.service.UserService;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/set-user")
    public User setUser(@RequestParam("userName") String userName, @RequestParam("userProfile") MultipartFile userProfile, @RequestParam("contactNo") String contactNo, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("userAddress") String userAddress, @RequestParam("roleType") String roleType) throws IOException {
        return userService.setUser(userName, userProfile, contactNo, email, password, userAddress, roleType);
    }

    @PutMapping(path = "/update-user/{userId}")
    public User updateUserById(@RequestParam("userName") String userName, @RequestParam("userProfile") MultipartFile userProfile, @RequestParam("contactNo") String contactNo, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("userAddress") String userAddress, @RequestParam("roleType") String roleType, @PathVariable("userId") int userId) throws IOException {
        return userService.updateUserById(userName, userProfile, contactNo, email, password, userAddress, roleType, userId);
    }

    @GetMapping(path = "/view-all-users")
    public List<User> viewAllUsers() {
        return userService.viewAllUsers();
    }
    
    @GetMapping(path = "/view-all-users-by-role")
    public List<User> viewAllUsersByRoleType(@RequestParam("roleType") String roleType) {
        return userService.viewAllUsersByRoleType(roleType);
    }
    
    @GetMapping(path = "/view-all-users/{userId}")
    public Optional<User> viewAllUsersById(@PathVariable("userId") int userId) {
        return userService.viewAllUsersById(userId);
    }

    @DeleteMapping(path = "/delete-user/{userId}")
    public void deleteUserById(@RequestParam("userId") int userId) {
        userService.deleteUserById(userId);
    }
    
    @GetMapping(path = "/user-login")
    public Optional<User> userLogin(@RequestParam("email") String email,@RequestParam("password") String password){
       return userService.userLogin(email,password);
    }
}
