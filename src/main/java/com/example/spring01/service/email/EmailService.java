package com.example.spring01.service.email;

import com.example.spring01.model.email.EmailDTO;

public interface EmailService {
	public void sendMail(EmailDTO dto);
}
