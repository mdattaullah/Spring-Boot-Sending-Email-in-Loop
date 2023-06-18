package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@Autowired
	JavaMailSender emailSender;
	
	@RequestMapping("/email")
	public String sendEmail() {
		for(int i=0;i<9;i++) {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setFrom("noreply@gmail.com");
		mailMessage.setTo("2parimeta@gmail.com");
		mailMessage.setText("Hi, This Mail purpose for only fun! ): "+"Enjoy your day "+i);
		mailMessage.setSubject("Spring Boot Mail"+i);
		
		emailSender.send(mailMessage);
		}
		return "Mail Sent";
		
	}
	
}
