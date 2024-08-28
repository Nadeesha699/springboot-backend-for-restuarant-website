/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.controller;

import com.example.example.data.Setting;
import com.example.example.service.SettingService;
import java.io.IOException;
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
public class SettingController {
     @Autowired 
     SettingService settingService;
    
    @PostMapping(path = "/set-setting")
    public Setting setSetting(@RequestParam("restuarantName") String restuarantName,@RequestParam("restuarantAbout") String restuarantAbout,@RequestParam("restuarantLogo") MultipartFile restuarantLogo,@RequestParam("restuarantCoverPhoto") MultipartFile restuarantCoverPhoto,@RequestParam("restuarantEmail") String restuarantEmail,@RequestParam("restuarantContactNo") String restuarantContactNo,@RequestParam("restuarantAddress") String restuarantAddress, @RequestParam("restuarantOpentime") String restuarantOpentime) throws IOException{
       return settingService.setSetting(restuarantName,restuarantAbout,restuarantLogo,restuarantCoverPhoto,restuarantEmail,restuarantContactNo,restuarantAddress, restuarantOpentime); 
    }
    
    @GetMapping(path = "/get-setting-by-id/{id}")
    public Optional<Setting> getSettingById(@PathVariable("id") int id){
      return settingService.getSettingById(id);
    }
    
    @PutMapping(path = "/update-setting/{id}")
    public Setting updateSetting(@RequestParam("restuarantName") String restuarantName,@RequestParam("restuarantAbout") String restuarantAbout,@RequestParam("restuarantLogo") MultipartFile restuarantLogo,@RequestParam("restuarantCoverPhoto") MultipartFile restuarantCoverPhoto,@RequestParam("restuarantEmail") String restuarantEmail,@RequestParam("restuarantContactNo") String restuarantContactNo,@RequestParam("restuarantAddress") String restuarantAddress, @RequestParam("restuarantOpentime") String restuarantOpentime,@PathVariable("id") int id) throws IOException{
       return settingService.updateSetting(restuarantName,restuarantAbout,restuarantLogo,restuarantCoverPhoto,restuarantEmail,restuarantContactNo,restuarantAddress, restuarantOpentime,id); 
    }
    
    @DeleteMapping(path = "/delete-setting/{id}")
    public void deleteSettingById(@PathVariable("id") int id){
      settingService.deleteSettingById(id);
    }
}
