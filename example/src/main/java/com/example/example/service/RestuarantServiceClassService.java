/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.service;

import com.example.example.data.RestaurantService;
import com.example.example.data.RestaurantServiceRepository;
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
public class RestuarantServiceClassService {
    
    @Autowired
    RestaurantServiceRepository restaurantServiceRepository;
    
    public RestaurantService setService(String serviceName,String serviceDiscription,MultipartFile file) throws IOException {
        RestaurantService restaurantService = new RestaurantService();
        restaurantService.setServiceName(serviceName);
        restaurantService.setServiceDiscription(serviceDiscription);
        restaurantService.setServiceImage(file.getBytes());
        return restaurantServiceRepository.save(restaurantService);
    }
    
    public List<RestaurantService> getAllServices() {
        return restaurantServiceRepository.findAll();
    }
    
    public RestaurantService updateServiceBYId(String serviceName,String serviceDiscription,MultipartFile file, int id) throws IOException {
        RestaurantService restaurantService = new RestaurantService();
        if (!restaurantServiceRepository.findById(id).isEmpty()) {
            restaurantService.setServiceDiscription(serviceDiscription);
            restaurantService.setServiceName(serviceName);
            restaurantService.setServiceImage(file.getBytes());
            restaurantService.setId(id);
            return restaurantServiceRepository.save(restaurantService);
        } else {
            return null;
        }
    }
    
    public void deleteServiceById(int id) {
        restaurantServiceRepository.deleteById(id);
    }
}
