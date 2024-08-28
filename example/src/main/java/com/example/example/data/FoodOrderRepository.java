/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.example.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {

    public List<FoodOrder> findAllByCustomerId(int customerId);

    public List<FoodOrder> findAllByOrderStatus(String orderStatus);
    
}
