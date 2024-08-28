/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.controller;

import com.example.example.data.TableBook;
import com.example.example.service.TableBookService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */



@RestController
@RequestMapping("/api")
public class TableBookController {
    
    
    
    @Autowired
    TableBookService tableBookService;
    
    @PostMapping(path = "/add-booking")
    public TableBook setBooking(@RequestBody TableBook tablebook){
      return tableBookService.setBooking(tablebook);  
    }
    
    @GetMapping(path = "/view-all-booking")
    public List<TableBook> getAllBooking(){
      return tableBookService.getAllBooking();  
    }
    
    @DeleteMapping(path = "/delete-booking/{id}")
    public void deleteBookingById(@PathVariable("id") int id){
      tableBookService.deleteBookingById(id);
    }
    
    @PutMapping(path = "/update-booking/{id}")
    public TableBook updateBookingBYId(@RequestBody TableBook tablebook, @PathVariable("id") int id){
      return tableBookService.updateBookingBYId(tablebook,id);  
    }
    
    @GetMapping(path="/view-booking-by-email")
    public List<TableBook> getBookingByEmail(@RequestParam("email") String email){
        return tableBookService.getBookingByEmail(email);
    }
    
    @GetMapping(path="/view-booking-by-id")
    public Optional<TableBook> getBookingById(@RequestParam("id") int id){
        return tableBookService.getBookingById(id);
    }
    
     @GetMapping(path="/view-booking-by-status")
    public List<TableBook> getBookingByStatus(@RequestParam("status") String status) {
        return tableBookService.getBookingByStatus(status);
    }
    
    
}
