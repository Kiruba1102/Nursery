package com.nurs.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Component
@Entity
public class CartItem {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int cartId;
  private int quantity;
 

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "cid")
  private Customer customer;

  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "pid")
  private Plant plant;

  
  
public CartItem() {
	super();
}

public CartItem(int cartId, int quantity, Customer customer, Plant plant) {
	super();
	this.cartId = cartId;
	this.quantity = quantity;
	this.customer = customer;
	this.plant = plant;
}

public int getCartId() {
	return cartId;
}

public void setCartId(int cartId) {
	this.cartId = cartId;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public Plant getPlant() {
	return plant;
}

public void setPlant(Plant plant) {
	this.plant = plant;
}

}
