package com.example.example.controller;

import com.example.example.data.RestaurantService;
import com.example.example.service.RestuarantServiceClassService;
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
public class RestaurantServiceController {
    
    @Autowired 
    RestuarantServiceClassService restuarantServiceClassService;
    
    @PostMapping(path = "/add-service")
    public RestaurantService setService(@RequestParam("serviceName") String serviceName,@RequestParam("serviceDiscription") String serviceDiscription,@RequestParam("serviceImage") MultipartFile file) throws IOException{
       return restuarantServiceClassService.setService(serviceName,serviceDiscription,file); 
    }
    
    @GetMapping(path = "/view-all-service")
    public List<RestaurantService> getAllServices(){
      return restuarantServiceClassService.getAllServices();  
    }
    
    @PutMapping(path = "/update-service/{id}")
    public RestaurantService updateServiceBYId(@RequestParam("serviceName") String serviceName,@RequestParam("serviceDiscription") String serviceDiscription,@RequestParam("serviceImage") MultipartFile file, @PathVariable("id") int id) throws IOException{
      return restuarantServiceClassService.updateServiceBYId(serviceName,serviceDiscription ,file ,id);  
    }
    
    @DeleteMapping(path = "/delete-service/{id}")
    public void deleteServiceById(@PathVariable("id") int id){
      restuarantServiceClassService.deleteServiceById(id);
    }
}
