package com.nurs.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
;
 
@Service
 
public class MailServiceImplement implements com.nurs.service.MailService {

	@Autowired
	private JavaMailSender mailsender;
	public void sendMail(String toMail ,String subject,String body) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("plantZo@gmail.com");
		message.setTo(toMail);
		message.setText(body);
		message.setSubject(subject);
		mailsender.send(message);
		System.out.println("sended");
	}
}
