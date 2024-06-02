package com.nurs.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nurs.model.Shipping;
import com.nurs.service.ShippingService;

@SpringBootTest
public class ShippingTest {
	
	@Autowired
	  private ShippingService shippingService;

	
	@Test
	void test_allShipping() {
		 List<Shipping> shippings = shippingService.getAllShippings();
		  assertNotNull(shippings);	
	}
	
	
	@Test
	void test_allShippingById() {
		 Shipping shipping = shippingService.getShippingById(1);
		  assertNotNull(shipping);	
	}
	
	
}
