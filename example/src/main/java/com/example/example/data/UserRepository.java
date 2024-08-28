/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.example.data;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    public Optional<User> findByEmail(String email);

    public List<User> findAllByRoleType(String roleType);

    
}
