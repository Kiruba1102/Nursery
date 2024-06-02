package com.nurs.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nurs.service.MailService;
  
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class MailController {

 
	@Autowired 
	MailService serv;
 
	@PostMapping("/sendmail")
	public String sendOTPEmail(@RequestParam("email")String email){
		System.out.println(email);
		String toMail = email;
		String subject = "Plant Zo- Order Confirmation";
		String body = "Thank you for shopping with us! We look forward to serving you again.\r\n"
				+ "\r\n"
				+ "Best regards, Plant Zo  www.plantzo.com";
		try {
			serv.sendMail(toMail, subject, body);
			return "Mail Sent Successfully";
		}catch(Exception e) {
			return "Mail Send Failure";
		}
 
	}
}
