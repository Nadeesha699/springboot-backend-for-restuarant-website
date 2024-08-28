/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.service;

import com.example.example.data.Restuarantgallery;
import com.example.example.data.RestuarantgalleryRepository;
import com.example.example.data.SettingRepository;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
@Service
public class RestuarantgalleryService {

    @Autowired
    RestuarantgalleryRepository restuarantgalleryRepository;
    
    @Autowired
    SettingRepository settingRepository;

    public Restuarantgallery setGallery(MultipartFile file, int settingId) throws IOException {
        Restuarantgallery restuarantgallery = new Restuarantgallery();
        if (!settingRepository.findById(settingId).isEmpty()) {
            restuarantgallery.setGalleryImage(file.getBytes());
            restuarantgallery.setSettingId(settingId);
            return restuarantgalleryRepository.save(restuarantgallery);
        } else {
            return null;
        }

    }

    public Restuarantgallery updateGalleryByid(MultipartFile file, int settingId, int galleryId) throws IOException {
        Restuarantgallery restuarantgallery = new Restuarantgallery();
        if (!restuarantgalleryRepository.findById(galleryId).isEmpty()) {
            restuarantgallery.setGalleryImage(file.getBytes());
            restuarantgallery.setSettingId(settingId);
            restuarantgallery.setGalleryId(galleryId);
            return restuarantgalleryRepository.save(restuarantgallery);
        } else {
            return null;
        }
    }

    public List<Restuarantgallery> viewGalleryByid(int settingId) {
        return restuarantgalleryRepository.findAllBySettingId(settingId);
    }

    public void deleteGalleryByid(int settingId) {
        restuarantgalleryRepository.deleteAllBySettingId(settingId);
    }
}
