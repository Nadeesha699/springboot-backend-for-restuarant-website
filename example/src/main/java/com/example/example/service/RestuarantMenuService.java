/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.service;

import com.example.example.data.RestaurantMenu;
import com.example.example.data.RestaurantMenuRepository;
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
public class RestuarantMenuService {

    @Autowired
    RestaurantMenuRepository restaurantMenuRepository;

    public RestaurantMenu setMenu(String mealName, String mealPrice, String mealRate, String mealType, String mealDicription, MultipartFile file) throws IOException {
        RestaurantMenu restaurantMenu = new RestaurantMenu();
        restaurantMenu.setMealName(mealName);
        restaurantMenu.setMealPrice(mealPrice);
        restaurantMenu.setMealRate(mealRate);
        restaurantMenu.setMealType(mealType);
        restaurantMenu.setMealDicription(mealDicription);
        restaurantMenu.setMealImage(file.getBytes());
        return restaurantMenuRepository.save(restaurantMenu);
    }

    public List<RestaurantMenu> getAllMenus() {
        return restaurantMenuRepository.findAll();
    }
    
    public List<RestaurantMenu> getAllMenusByType(String mealType) {
        return restaurantMenuRepository.findAllByMealType(mealType);
    }
    

    public RestaurantMenu updateMenuBYId(String mealName, String mealPrice, String mealRate, String mealType, String mealDicription, MultipartFile file, int id) throws IOException {
        RestaurantMenu restaurantMenu = new RestaurantMenu();
        if (!restaurantMenuRepository.findById(id).isEmpty()) {
            restaurantMenu.setMealName(mealName);
            restaurantMenu.setMealPrice(mealPrice);
            restaurantMenu.setMealRate(mealRate);
            restaurantMenu.setMealType(mealType);
            restaurantMenu.setMealDicription(mealDicription);
            restaurantMenu.setMealImage(file.getBytes());
            restaurantMenu.setMealId(id);
            return restaurantMenuRepository.save(restaurantMenu);
        } else {
            return null;
        }
    }

    public void deleteMenuById(int id) {
        restaurantMenuRepository.deleteById(id);
    }
}
