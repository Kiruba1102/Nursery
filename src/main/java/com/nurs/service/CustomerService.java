package com.nurs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurs.model.Customer;
import com.nurs.repo.CustomerRepositoryImpl;

@Service
public class CustomerService {
  @Autowired
  private CustomerRepositoryImpl customerRepository;
  
  public Customer saveCustomer(Customer customer) {
    return customerRepository.save(customer);
  }
 
  
  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }
  
  public void deleteCustomer(int id) {
    customerRepository.deleteById(id);
  }
  
  public Customer updateCustomer(Customer customer) {
	    return customerRepository.save(customer);
	  }

public void save(Customer customer) {
	   customerRepository.save(customer);
}
}
 

