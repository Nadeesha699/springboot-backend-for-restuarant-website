/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.service;

import com.example.example.data.FoodOrderIList;
import com.example.example.data.FoodOrderIListRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class FoodOrderIListService {

    @Autowired
    FoodOrderIListRepository foodOrderIListRepositiry;

    public FoodOrderIList setOrderItem(FoodOrderIList foodOrderIList) {
        return foodOrderIListRepositiry.save(foodOrderIList);
    }

    public FoodOrderIList updateOrderItemByOrderItemId(FoodOrderIList foodOrderIList, int orderItemId) {
        if (foodOrderIListRepositiry.findById(orderItemId).isPresent()) {
            foodOrderIList.setMealId(foodOrderIList.getMealId());
            foodOrderIList.setOrderId(foodOrderIList.getOrderId());
            foodOrderIList.setPrice(foodOrderIList.getPrice());
            foodOrderIList.setQuantity(foodOrderIList.getQuantity());
            foodOrderIList.setOrderItemId(orderItemId);
            return foodOrderIListRepositiry.save(foodOrderIList);
        } else {
            return null;
        }
    }
    
    public List<FoodOrderIList> viewAllOrderItem(){
      return foodOrderIListRepositiry.findAll();
    }
    
    public List<FoodOrderIList> viewAllOrderItemByOrderId(int orderId){
      return foodOrderIListRepositiry.findAllByOrderId(orderId);
    }
    
    public Optional<FoodOrderIList> viewAllOrderItemByOrderItemid(int orderItemId){
      return foodOrderIListRepositiry.findById(orderItemId);
    }
    
    public void deleteOrderItems() {
        foodOrderIListRepositiry.deleteAll();
    }

    public void deleteOrderItemsByOrderId(int orderId) {
        foodOrderIListRepositiry.deleteAllByOrderId(orderId);
    }

    public void deleteOrderItemByOrderItemid(int orderItemId) {
        foodOrderIListRepositiry.deleteById(orderItemId);
    }
}
