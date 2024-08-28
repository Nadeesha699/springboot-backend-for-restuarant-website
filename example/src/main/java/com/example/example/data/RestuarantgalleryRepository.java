/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.example.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HP
 */
public interface RestuarantgalleryRepository extends JpaRepository<Restuarantgallery, Integer>{

    public List<Restuarantgallery> findAllBySettingId(int settingId);

    public void deleteAllBySettingId(int settingId);
    
}
