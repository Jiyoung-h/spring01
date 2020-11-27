package com.example.spring01.service.email;

import javax.inject.Inject;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.spring01.model.email.EmailDTO;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Inject
	JavaMailSender mailSender;
	
	@Override
	public void sendMail(EmailDTO dto) {
		try {
			MimeMessage msg = mailSender.createMimeMessage();
			msg.addRecipient(RecipientType.TO, new InternetAddress(dto.getReceiveMail()));
			msg.addFrom(new InternetAddress[] {
					new InternetAddress(dto.getSenderMail(), dto.getSenderName())
			});
			msg.setSubject(dto.getSubject(), "utf-8");
			msg.setText(dto.getMessage(), "utf-8");
			mailSender.send(msg);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
