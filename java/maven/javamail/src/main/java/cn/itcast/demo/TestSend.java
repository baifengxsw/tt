package cn.itcast.demo;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class TestSend {
	private JavaMailSender javaMailSender;

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendMail() throws MessagingException {
		//创建邮件
		MimeMessage message = javaMailSender.createMimeMessage();
		//邮件包装工具
		MimeMessageHelper helper = new MimeMessageHelper(message);
		//发件人
		helper.setFrom("1072396463@qq.com");
		//收件人
		helper.setTo("xiashuangwu@126.com");
		//邮件标题
		helper.setSubject("测试邮件");
		//邮件内容
		helper.setText("这是我的测试邮件啊，你收到了嘛");
		javaMailSender.send(message);
		
	}
}
