package com.agentdesk.market.util;

//import java.util.Properties;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail {
	
	public static void sendEmailMessage(Properties props, String[] toEmail, 
			String fromEmail, String password, String subject, 
			String msgText) throws MessagingException {
		
		if (props==null || toEmail==null || toEmail.length==0) {
			return;
		}
		
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(fromEmail, password);
					}
				});
		
		Address[] toAddress = new InternetAddress[toEmail.length];
		for (int i=0; i<toEmail.length; i++) {
			toAddress[i] = new InternetAddress(toEmail[i]);
		}
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromEmail));
		message.setRecipients(Message.RecipientType.TO, toAddress);
		message.setSubject(subject);
		message.setText(msgText);

		Transport.send(message);
	}
	
}
