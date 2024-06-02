package com.nurs.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurs.model.Admin;
import com.nurs.repo.AdminRepositoryImpl;

@Service
public class AdminService {
  @Autowired
  private AdminRepositoryImpl adminRepository;
  
  public Admin saveAdmin(Admin admin) {
	
    return adminRepository.save(admin);
  }
  
  public List<Admin> getAll() {
		
	    return adminRepository.findAll();
	  }
}
