/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.controller;

import com.example.example.data.FoodOrder;
import com.example.example.service.FoodOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */

@RestController
@RequestMapping("/api")
public class FoodOrderController {
    
    @Autowired
    FoodOrderService foodOrderService;
    
    @PostMapping(path= "/set-food-order")
    public FoodOrder setOrder(@RequestBody FoodOrder foodOrder){
        return foodOrderService.setOrder(foodOrder);
    }
    
    @PutMapping(path= "/update-food-order/{orderId}")
    public FoodOrder upadteOrderById(@RequestBody FoodOrder foodOrder,@PathVariable("orderId") int orderId){
        return foodOrderService.upadteOrderById(foodOrder,orderId);
    }
    
    
    @GetMapping(path = "/view-all-food-orders")
    public List<FoodOrder> viewAllOrders(){
        return foodOrderService.viewAllOrders();
    }
    
    @GetMapping(path = "/view-all-food-orders/{customerId}")
    public List<FoodOrder> viewAllOrdersByCustomerId(@PathVariable("customerId") int customerId){
        return foodOrderService.viewAllOrdersByCustomerId(customerId);
    }
    
    @GetMapping(path = "/view-all-food-orders-by-status")
    public List<FoodOrder> viewAllOrdersByStatus(@RequestParam("orderStatus") String orderStatus){
        return foodOrderService.viewAllOrdersByStatus(orderStatus);
    }
    
    @DeleteMapping(path = "/delete/food-order/{orderId}")
    public void deleteOrderById(@PathVariable("orderId") int orderId){
       foodOrderService.deleteOrderById(orderId); 
    }
    
}
