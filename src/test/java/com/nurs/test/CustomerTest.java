package com.nurs.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nurs.model.Customer;
import com.nurs.repo.CustomerRepositoryImpl;
import com.nurs.service.CustomerService;

@SpringBootTest
public class CustomerTest {
	
	 @Autowired
	  private CustomerService customerService;
	 @Autowired
	  private CustomerRepositoryImpl crtRepo;
	 
	 @Test
	 void getCustomer() {
		  List<Customer> customers = customerService.getAllCustomers();
		  assertNotNull(customers);
	 }
	 
	 @Test
	 void getCustomerById() {
		 Customer cust = crtRepo.getUserData(8);
		  assertNotNull(cust);
	 }

}
