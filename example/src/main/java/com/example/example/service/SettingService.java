/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.service;

import com.example.example.data.Setting;
import com.example.example.data.SettingRepository;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
@Service
public class SettingService {
    
    @Autowired
    SettingRepository settingRepository;
    
    public Setting setSetting(String restuarantName, String restuarantAbout, MultipartFile restuarantLogo, MultipartFile restuarantCoverPhoto, String restuarantEmail, String restuarantContactNo, String restuarantAddress, String restuarantOpentime) throws IOException {
        Setting setting = new Setting();
        setting.setRestuarantName(restuarantName);
        setting.setRestuarantAbout(restuarantAbout);
        setting.setRestuarantLogo(restuarantLogo.getBytes());
        setting.setRestuarantCoverPhoto(restuarantCoverPhoto.getBytes());
        setting.setRestuarantEmail(restuarantEmail);
        setting.setRestuarantContactNo(restuarantContactNo);
        setting.setRestuarantAddress(restuarantAddress);
        setting.setRestuarantOpentime(LocalTime.parse(restuarantOpentime));
        return settingRepository.save(setting);
    }
    
    public Optional<Setting> getSettingById(int id) {
        return settingRepository.findById(id);
    }
    
    public Setting updateSetting(String restuarantName, String restuarantAbout, MultipartFile restuarantLogo, MultipartFile restuarantCoverPhoto, String restuarantEmail, String restuarantContactNo, String restuarantAddress, String restuarantOpentime, int id) throws IOException {
        Setting setting = new Setting();
        if (!settingRepository.findById(id).isEmpty()) {
            setting.setRestuarantName(restuarantName);
            setting.setRestuarantAbout(restuarantAbout);
            setting.setRestuarantLogo(restuarantLogo.getBytes());
            setting.setRestuarantCoverPhoto(restuarantCoverPhoto.getBytes());
            setting.setRestuarantEmail(restuarantEmail);
            setting.setRestuarantContactNo(restuarantContactNo);
            setting.setRestuarantAddress(restuarantAddress);
            setting.setRestuarantOpentime(LocalTime.parse(restuarantOpentime));
            setting.setSettingId(id);
            return settingRepository.save(setting);
        } else {
            return null;
        }
        
    }
    
    public void deleteSettingById(int id) {
        settingRepository.deleteById(id);
    }
}
