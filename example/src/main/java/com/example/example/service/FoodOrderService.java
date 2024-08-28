/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.service;

import com.example.example.data.FoodOrder;
import com.example.example.data.FoodOrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class FoodOrderService {

    @Autowired
    FoodOrderRepository foodOrderRepository;

    public FoodOrder setOrder(FoodOrder foodOrder) {
        return foodOrderRepository.save(foodOrder);
    }

    public FoodOrder upadteOrderById(FoodOrder foodOrder, int orderId) {
        if (foodOrderRepository.findById(orderId).isPresent()) {
            foodOrder.setCustomerId(foodOrder.getCustomerId());
            foodOrder.setDeliveryAddress(foodOrder.getDeliveryAddress());
            foodOrder.setOrderDate(foodOrder.getOrderDate());
            foodOrder.setPaymentMethod(foodOrder.getPaymentMethod());
            foodOrder.setTotalAmout(foodOrder.getTotalAmout());
            foodOrder.setOrderStatus(foodOrder.getOrderStatus());
            foodOrder.setOrderId(orderId);
            return foodOrderRepository.save(foodOrder);
        } else {
            return null;
        }
    }
    
    public List<FoodOrder> viewAllOrders(){
        return foodOrderRepository.findAll();
    }
    
    public List<FoodOrder> viewAllOrdersByCustomerId(int customerId){
        return foodOrderRepository.findAllByCustomerId(customerId);
    }
    
    public List<FoodOrder> viewAllOrdersByStatus(String orderStatus){
        return foodOrderRepository.findAllByOrderStatus(orderStatus);
    }
    
    public void deleteOrderById(int orderId){
       foodOrderRepository.deleteById(orderId);
    }
}

