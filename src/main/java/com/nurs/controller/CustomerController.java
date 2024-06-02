package com.nurs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nurs.model.CartItem;
import com.nurs.model.Customer;
import com.nurs.repo.CartItemRepositoryImpl;
import com.nurs.repo.CustomerRepositoryImpl;
import com.nurs.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin("*")
public class CustomerController {
  @Autowired
  private CustomerService customerService;
  
  @Autowired
  private CustomerRepositoryImpl crtRepo;
  
  @PostMapping("/add")
  public String createCustomer(@RequestBody Customer customer) {
	  

	  String msg="";
	  try {
		  customerService.save(customer);
			msg = "Saved";

		} catch (Exception e) {
			msg = "Not saved";
		}
	
    
	return msg;
   
  }
  
 
  
  @GetMapping("/get")
  public ResponseEntity<List<Customer>> getAllCustomers() {
    List<Customer> customers = customerService.getAllCustomers();
    return ResponseEntity.ok(customers);
  }
  
  
  @GetMapping("cust/{cid}")
  public ResponseEntity<Customer> findByCustomerId(@PathVariable int cid) {
	  
	 
  Customer cust = crtRepo.getUserData(cid);
    if (cust == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(cust);
  }
}

