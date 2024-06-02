package com.nurs.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.nurs.model.CartItem;
import com.nurs.model.Shipping;
import com.nurs.repo.ShippingRepositoryImpl;
import com.nurs.service.ShippingService;

import jakarta.persistence.EntityManager;

@RestController
@RequestMapping("/api/shippings")
@CrossOrigin("*")
@Transactional

public class ShippingController {
 
	@Autowired
  private ShippingService shippingService;
	
	@Autowired
	private ShippingRepositoryImpl repo;
	
	@Autowired
	EntityManager entityManager;
  
  @PostMapping("")
  public ResponseEntity<Shipping> createShipping(@RequestBody Shipping shipping) {
    Shipping savedShipping = shippingService.saveShipping(shipping);
    return ResponseEntity.ok(savedShipping);
  }
  
  @SuppressWarnings("unchecked")
  @PostMapping("/post/{totalPrice}/{payment}")
  public ResponseEntity<String> shipping(@RequestBody List<CartItem> cartItems, 
                                         @PathVariable int totalPrice, 
                                         @PathVariable String payment) {
      try {
          if(cartItems != null && !cartItems.isEmpty() && totalPrice > 0) {
              Shipping shipping = new Shipping();
             
              List<CartItem> attachedCartItems = cartItems.stream()
                      .map(item -> entityManager.merge(item))
                      .collect(Collectors.toList());
              shipping.setCartItem(attachedCartItems); 
              shipping.setPayment(payment);
              shipping.setTotalPrice(totalPrice);
              repo.save(shipping);
              return ResponseEntity.ok("Order placed successfully.");
          } else {
              return ResponseEntity.badRequest().body("Invalid request data.");
          }
      } catch (Exception e) {
          // Log the exception for debugging purposes
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process the request.");
      }
  }



  
  
  @GetMapping("/{id}")
  public ResponseEntity<Shipping> getShippingById(@PathVariable int id) {
    Shipping shipping = shippingService.getShippingById(id);
    if (shipping == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(shipping);
  }
  
  @GetMapping("/orders")
  public ResponseEntity<List<Shipping>> getAllShippings() {
    List<Shipping> shippings = shippingService.getAllShippings();
    return ResponseEntity.ok(shippings);
  }

  
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteShipping(@PathVariable int id) {
    Shipping shipping = shippingService.getShippingById(id);
    if (shipping == null) {
      return ResponseEntity.notFound().build();
    }
    shippingService.deleteShipping(id);
    return ResponseEntity.noContent().build();
  }
  
 
}

