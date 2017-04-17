package core.java.mail.send.practice;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

public class SendMailUsingGmail {

	//	@Ignore
	@Test
	public void sendMailUsingGmailSSL() throws AddressException, MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("avinash4216@gmail.com", "2chocolate3icecream");
			}
		});
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("avinash4216@gmail.com"));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("avinashbabu.donthu@gmail.com"));
		message.setSubject("Gayathri subject");
		message.setText("Welcome to my mail :)");

		Transport.send(message);
		System.out.println("Mail Sent");
	}
}
