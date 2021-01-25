package luongnvpk.helper;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static void sendMail(String email){
		final String userName = "lgnvpr@gmail.com";
		final String passWord = "atenm2709csbhlvcx@gg";
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		javax.mail.Session session = javax.mail.Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, passWord);
			}
		});
		String emailTo = email;
		String Subject = "Xác nhận đăng ký!";
		String Content = "Chúc mừng bạn đã đăng ký thành công tài khoản!";
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			message.setSubject(Subject);
			message.setText(Content);
			Transport.send(message);
		} catch (Exception ex) {
			System.out.println("Send mail successfully!");
			ex.printStackTrace();
		}
	}
}
