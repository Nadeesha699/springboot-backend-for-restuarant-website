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
import java.time.LocalTime;

/**
 *
 * @author HP
 */
@Entity(name = "restuarant_setting")
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int settingId;

    @Column(name = "restuarant_name")
    private String restuarantName;

    @Column(name = "restuarant_about")
    private String restuarantAbout;

    @Column(name = "restuarant_logo")
    private byte[] restuarantLogo;

    @Column(name = "restuarant_cover_photo")
    private byte[] restuarantCoverPhoto;

    @Column(name = "restuarant_email")
    private String restuarantEmail;

    @Column(name = "restuarant_contact_no")
    private String restuarantContactNo;

    @Column(name = "restuarant_address")
    private String restuarantAddress;

    @Column(name = "restuarant_opentime")
    private LocalTime restuarantOpentime;

    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

    public String getRestuarantName() {
        return restuarantName;
    }

    public void setRestuarantName(String restuarantName) {
        this.restuarantName = restuarantName;
    }

    public String getRestuarantAbout() {
        return restuarantAbout;
    }

    public void setRestuarantAbout(String restuarantAbout) {
        this.restuarantAbout = restuarantAbout;
    }

    public byte[] getRestuarantLogo() {
        return restuarantLogo;
    }

    public void setRestuarantLogo(byte[] restuarantLogo) {
        this.restuarantLogo = restuarantLogo;
    }

    public byte[] getRestuarantCoverPhoto() {
        return restuarantCoverPhoto;
    }

    public void setRestuarantCoverPhoto(byte[] restuarantCoverPhoto) {
        this.restuarantCoverPhoto = restuarantCoverPhoto;
    }

    public String getRestuarantEmail() {
        return restuarantEmail;
    }

    public void setRestuarantEmail(String restuarantEmail) {
        this.restuarantEmail = restuarantEmail;
    }

    public String getRestuarantContactNo() {
        return restuarantContactNo;
    }

    public void setRestuarantContactNo(String restuarantContactNo) {
        this.restuarantContactNo = restuarantContactNo;
    }

    public String getRestuarantAddress() {
        return restuarantAddress;
    }

    public void setRestuarantAddress(String restuarantAddress) {
        this.restuarantAddress = restuarantAddress;
    }

    public LocalTime getRestuarantOpentime() {
        return restuarantOpentime;
    }

    public void setRestuarantOpentime(LocalTime restuarantOpentime) {
        this.restuarantOpentime = restuarantOpentime;
    }

}
