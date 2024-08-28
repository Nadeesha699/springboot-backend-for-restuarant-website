/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.controller;

import com.example.example.data.Restuarantgallery;
import com.example.example.service.RestuarantgalleryService;
import java.io.IOException;
import java.util.List;
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
public class RestuarantgalleryController {
    
    @Autowired
    RestuarantgalleryService restuarantgalleryService;
   
    @PostMapping(path = "/add-new-gallery-image/{settingId}")
    public Restuarantgallery setGallery(@RequestParam("galleryImage") MultipartFile file, @PathVariable("settingId") int settingId) throws IOException{
      return restuarantgalleryService.setGallery(file, settingId);  
    }
    
    @PutMapping(path = "/update-gallery-image/{settingId}/{galleryId}")
    public Restuarantgallery updateGalleryByid(@RequestParam("galleryImage") MultipartFile file, @PathVariable("settingId") int settingId, @PathVariable("galleryId") int galleryId) throws IOException{
      return restuarantgalleryService.updateGalleryByid(file, settingId,galleryId);  
    }
    
    @GetMapping(path= "veiw-gallery-images/{settingId}")
    public List<Restuarantgallery> viewGalleryByid(@PathVariable("settingId") int settingId){
      return restuarantgalleryService.viewGalleryByid(settingId);  
    }
    
    @DeleteMapping(path= "delete-gallery-images/{settingId}")
    public void deleteGalleryByid(@PathVariable("settingId") int settingId){
       restuarantgalleryService.deleteGalleryByid(settingId);  
    }
}
