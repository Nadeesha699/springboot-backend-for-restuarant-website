/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.service;

import com.example.example.data.Test;
import com.example.example.data.TestRepository;
import java.io.IOException;
import java.time.LocalDateTime;
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
public class TestService {

    @Autowired
    TestRepository testrepository;

    PasswordEncoder passwordEncoder;

    public Test setDate(LocalDateTime date, MultipartFile file, String password) throws IOException {
        this.passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        Test test = new Test();
        test.setDate(date);
        test.setPassword(encodedPassword);
        test.setImageData(file.getBytes());
        return testrepository.save(test);
    }
}
