package cn.itcast.erp.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailUtil {
	private JavaMailSender sender;//spring邮件发送类
	private String from  ;//发件人
	
	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void sendMail(String to ,String subject ,String text) throws MessagingException {
		//创建邮件
		MimeMessage message = sender.createMimeMessage();
		//邮件类包装工具
		MimeMessageHelper helper = new MimeMessageHelper(message);
		//发件人
		helper.setFrom(from);
		//收件人
		helper.setTo(to);
		//邮件标题
		helper.setSubject(subject);
		//邮件内容
		helper.setText(text);
		//发送邮件
		sender.send(message);
		
	}
}
