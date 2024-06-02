package com.nurs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nurs.model.Shipping;
import com.nurs.repo.ShippingRepositoryImpl;

@Service
@Transactional
public class ShippingService {
  @Autowired
  private ShippingRepositoryImpl shippingRepository;
  
  public Shipping saveShipping(Shipping shipping) {
    return shippingRepository.save(shipping);
  }
  
  public Shipping getShippingById(int id) {
    return shippingRepository.findById(id);
  }
  
  public List<Shipping> getAllShippings() {
    return shippingRepository.findAll();
  }
  
  public void deleteShipping(int id) {
    shippingRepository.deleteById(id);
  }
  
  public Shipping updateShipping(Shipping shipping) {
    return shippingRepository.save(shipping);
  }
}
