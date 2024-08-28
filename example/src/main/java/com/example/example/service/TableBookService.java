/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.example.service;

import com.example.example.data.TableBook;
import com.example.example.data.TableBookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class TableBookService {

    @Autowired
    TableBookRepository tableBookRepository;

    public TableBook setBooking(TableBook tablebook) {
        return tableBookRepository.save(tablebook);
    }

    public List<TableBook> getAllBooking() {
        return tableBookRepository.findAll();
    }

    public void deleteBookingById(int id) {
        tableBookRepository.deleteById(id);
    }

    public TableBook updateBookingBYId(TableBook tablebook, int id) {
        if (!tableBookRepository.findById(id).isEmpty()) {
            tablebook.setUserName(tablebook.getUserName());
            tablebook.setBookingCount(tablebook.getBookingCount());
            tablebook.setStatus(tablebook.getStatus());
            tablebook.setEmail(tablebook.getEmail());
            tablebook.setDateTime(tablebook.getDateTime());
            tablebook.setBookId(id);
            return tableBookRepository.save(tablebook);
        } else {
            return null;
        }
    }
  
 
    public List<TableBook> getBookingByEmail(String email){
        return tableBookRepository.findAllByEmail(email);
    }
    
    public Optional<TableBook> getBookingById(int id){
        return tableBookRepository.findById(id);
    }
    
    public List<TableBook> getBookingByStatus(String Status) {
        return tableBookRepository.findAllByStatus(Status);
    }
}
