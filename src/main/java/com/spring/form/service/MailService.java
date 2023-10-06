package com.spring.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService 
{
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendRegistrationMail(String toMail, String subject, String messageBody)
	{
		SimpleMailMessage mailMessage  = new SimpleMailMessage();
		mailMessage.setTo(toMail);
		mailMessage.setSubject(subject);
		mailMessage.setText(messageBody);
		mailSender.send(mailMessage);
	}
	
}
