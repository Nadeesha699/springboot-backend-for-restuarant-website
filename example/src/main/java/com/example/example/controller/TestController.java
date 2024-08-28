/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.controller;

import com.example.example.data.Test;
import com.example.example.service.TestService;
import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class TestController {
    
    @Autowired
    TestService testservice;
    
    @PostMapping(path = "/test")
    public Test setDate(@RequestParam("date") LocalDateTime date, @RequestParam("image") MultipartFile file,@RequestParam("passord") String password) throws IOException{
     return  testservice.setDate(date,file,password);
    }
}
