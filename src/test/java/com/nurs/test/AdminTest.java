package com.nurs.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nurs.model.Admin;
import com.nurs.service.AdminService;

@SpringBootTest
public class AdminTest {

	@Autowired
	AdminService service;
	
	@Test
	void test_validate() {
		List<Admin> admin = service.getAll();
		assertNotNull(admin);
	}
	
}
