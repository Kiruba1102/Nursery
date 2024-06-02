
package com.nurs.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity

public class Shipping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shipId;
	private String payment;
	private int totalPrice;
	

	@OneToMany(cascade = CascadeType.ALL, targetEntity = CartItem.class)
	private List<CartItem> cartItem;

	public Shipping() {
		super();
	}

	public Shipping(int shipId, String payment, int totalPrice, List<CartItem> cartItem) {
		super();
		this.shipId = shipId;
		this.payment = payment;
		this.totalPrice = totalPrice;
		this.cartItem = cartItem;
	}

	public int getShipId() {
		return shipId;
	}

	public void setShipId(int shipId) {
		this.shipId = shipId;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
}
