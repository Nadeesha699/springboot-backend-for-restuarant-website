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

@Entity(name="restaurant_menu")
public class RestaurantMenu {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mealId; 
   
   @Column(name="meal_name")
   private String mealName;
   
   @Column(name="meal_price")
   private String mealPrice;
   
   @Column(name="meal_rate")
   private String mealRate;
   
   @Column(name="meal_type")
   private String mealType;
   
   @Column(name="meal_discription")
   private String mealDicription;
   
   @Column(name="meal_image")
   private byte[] mealImage;

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(String mealPrice) {
        this.mealPrice = mealPrice;
    }

    public String getMealRate() {
        return mealRate;
    }

    public void setMealRate(String mealRate) {
        this.mealRate = mealRate;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getMealDicription() {
        return mealDicription;
    }

    public void setMealDicription(String mealDicription) {
        this.mealDicription = mealDicription;
    }

    public byte[] getMealImage() {
        return mealImage;
    }

    public void setMealImage(byte[] mealImage) {
        this.mealImage = mealImage;
    }
   
   
}
