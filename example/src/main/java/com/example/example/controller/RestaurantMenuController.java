/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.controller;

import com.example.example.data.RestaurantMenu;
import com.example.example.service.RestuarantMenuService;
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
public class RestaurantMenuController {

    @Autowired
    RestuarantMenuService restuarantMenuService;

    @PostMapping(path = "/add-menu")
    public RestaurantMenu setMenu(@RequestParam("mealName") String mealName, @RequestParam("mealPrice") String mealPrice, @RequestParam("mealRate") String mealRate, @RequestParam("mealType") String mealType, @RequestParam("mealDicription") String mealDicription, @RequestParam("mealImage") MultipartFile file) throws IOException {
        return restuarantMenuService.setMenu(mealName, mealPrice, mealRate, mealType, mealDicription, file);
    }

    @GetMapping(path = "/view-all-menu")
    public List<RestaurantMenu> getAllMenus() {
        return restuarantMenuService.getAllMenus();
    }

    @GetMapping(path = "/view-all-menu-by-type")
    public List<RestaurantMenu> getAllMenusByType(@RequestParam("mealType") String mealType) {
        return restuarantMenuService.getAllMenusByType(mealType);
    }

    @PutMapping(path = "/update-menu/{id}")
    public RestaurantMenu updateMenuBYId(@RequestParam("mealName") String mealName, @RequestParam("mealPrice") String mealPrice, @RequestParam("mealRate") String mealRate, @RequestParam("mealType") String mealType, @RequestParam("mealDicription") String mealDicription, @RequestParam("mealImage") MultipartFile file, @PathVariable("id") int id) throws IOException {
        return restuarantMenuService.updateMenuBYId(mealName, mealPrice, mealRate, mealType, mealDicription, file, id);
    }

    @DeleteMapping(path = "/delete-menu/{id}")
    public void deleteMenuById(@PathVariable("id") int id) {
        restuarantMenuService.deleteMenuById(id);
    }
}
