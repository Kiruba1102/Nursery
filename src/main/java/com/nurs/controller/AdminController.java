package com.nurs.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nurs.model.Admin;
import com.nurs.service.AdminService;

@RestController
@RequestMapping("")
@CrossOrigin("http://localhost:3000")
public class AdminController {
  @Autowired
  private AdminService adminService;
  
  @PostMapping("/admin")
  public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
    Admin savedAdmin = adminService.saveAdmin(admin);
    return ResponseEntity.ok(savedAdmin);
  }
  
     @GetMapping("/getadmin")
     
     public ResponseEntity<List<Admin>> findAdmin() {
    	    List<Admin> savedAdmin = adminService.getAll();
    	    return ResponseEntity.ok(savedAdmin);
    	  
}
  
 
}
