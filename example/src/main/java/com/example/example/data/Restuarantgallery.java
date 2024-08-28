/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author HP
 */

@Entity(name="restuarant_gallery")
public class Restuarantgallery {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int galleryId;
    
    @Column(name= "gallery_image")
    private byte[] galleryImage;
    
    @Column(name="setting_id")
    private int settingId;

    public int getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }

    public byte[] getGalleryImage() {
        return galleryImage;
    }

    public void setGalleryImage(byte[] galleryImage) {
        this.galleryImage = galleryImage;
    }

    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }
    
    
}
