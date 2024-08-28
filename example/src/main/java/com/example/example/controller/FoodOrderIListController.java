/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.controller;

import com.example.example.data.FoodOrderIList;
import com.example.example.service.FoodOrderIListService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api")
public class FoodOrderIListController {

    @Autowired
    FoodOrderIListService foodOrderIListController;

    @PostMapping(path = "/set-order-item")
    public FoodOrderIList setOrderItem(@RequestBody FoodOrderIList foodOrderIList) {
        return foodOrderIListController.setOrderItem(foodOrderIList);
    }

    @PutMapping(path = "/update-order-item/{orderItemId}")
    public FoodOrderIList updateOrderItemByOrderItemId(@RequestBody FoodOrderIList foodOrderIList, @PathVariable("orderItemId") int orderItemId) {
        return foodOrderIListController.updateOrderItemByOrderItemId(foodOrderIList, orderItemId);
    }

    @GetMapping(path = "/view-all-order-items")
    public List<FoodOrderIList> viewAllOrderItem() {
        return foodOrderIListController.viewAllOrderItem();
    }

    @GetMapping(path = "/view-all-order-items/{orderId}")
    public List<FoodOrderIList> viewAllOrderItemByOrderId(@PathVariable("orderId") int orderId) {
        return foodOrderIListController.viewAllOrderItemByOrderId(orderId);
    }

    @GetMapping(path = "/view-order-item/{orderItemId}")
    public Optional<FoodOrderIList> viewOrderItemByOrderItemid(@PathVariable("orderItemId") int orderItemId) {
        return foodOrderIListController.viewAllOrderItemByOrderItemid(orderItemId);
    }

    @DeleteMapping(path = "/delete-all-order-items")
    public void deleteOrderItems() {
        foodOrderIListController.deleteOrderItems();
    }

    @DeleteMapping(path = "/delete-all-order-items/{orderId}")
    public void deleteOrderItemsByOrderId(@PathVariable("orderId") int orderId) {
        foodOrderIListController.deleteOrderItemsByOrderId(orderId);
    }

    @DeleteMapping(path = "/delete-order-items/{orderItemId}")
    public void deleteOrderItemByOrderItemid(@PathVariable("orderItemId") int orderItemId) {
        foodOrderIListController.deleteOrderItemByOrderItemid(orderItemId);
    }
}
