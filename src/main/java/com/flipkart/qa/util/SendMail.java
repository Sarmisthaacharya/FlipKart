package com.flipkart.qa.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendMail {
	
	public static void sendEMail() throws EmailException
	{
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("acharya.sarmistha@gmail.com", "sahajayoga"));
		//email.setSSLOnConnect(true);
		email.setSSL(true);
		email.setFrom("acharya.sarmistha@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("acharya.sarmistha@gmail.com");
		email.send();
	}

}
