package com.nurs.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nurs.model.CartItem;
import com.nurs.model.Customer;
import com.nurs.service.CartItemService;
import com.nurs.service.CustomerService;


@SpringBootTest
public class CartItemTest {

	

    @Autowired
    private CartItemService cartItemService;
    
    
	 @Test
	 void getCartItems() {
		 List<CartItem> cartItems = cartItemService.getAllCartItems();
		  assertNotNull(cartItems);
	 }
	 
	 @Test
	 void getCartItemsById() {
		 CartItem cartItem = cartItemService.getCartItemById(1);
		  assertNotNull(cartItem);
	 }

}
