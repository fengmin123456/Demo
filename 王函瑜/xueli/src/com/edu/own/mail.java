package com.edu.own;



import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

import com.webtest.dataprovider.NSDataProvider;



public class mail {

//���ı���ʽ�ʼ�����(+html)
	@Test(enabled=false)
	public void send_Text() throws Exception {
		String from="2798011643@qq.com";
		String to="2798011643@qq.com";
		String subject="����ɵ������";
		String body="������";
		String body2="<!DOCTYPE html><html><head><title></title><meta charset=\"utf-8\"><style type=\"text/css\">\r\n" + 
				"		#123{font-weight: 100;\r\n" + 
				"			font-style: italic;\r\n" + 
				"		}\r\n" + 
				"		.456{font-weight: 900;\r\n" + 
				"			font-style: italic;\r\n" + 
				"		}\r\n" + 
				"	</style></head><body>\r\n" + 
				"<div id=\"123\">\r\n" + 
				"	<div class=\"456\">\r\n" + 
				"		<p>����褻����·���Ƿ���</p>\r\n" + 
				"	</div></div></body></html>";
		String smtpHost = "smtp.qq.com";
		String port="25";
		// ����һ��Property�ļ�����
		Properties props = new Properties();
		// ʹ�õ�Э�飨JavaMail�淶Ҫ��
		props.put("mail.transport.protocol", "smtp");
		// �����ʼ�����������Ϣ����������smtp��������
		props.put("mail.smtp.host", smtpHost);
		// ����socket factory �Ķ˿�
		props.put("mail.smtp.socketFactory.port", "465");
		// ����socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		// ������Ҫ�����֤
		props.put("mail.smtp.auth", "true");
		// ����SMTP�Ķ˿ڣ�QQ��smtp�˿���25
		props.put("mail.smtp.port", port);
		
		//����Sessionʵ������
		Session session = Session.getInstance(props, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
                       // �ڶ���������������QQ����smtp����Ȩ��
			   return new PasswordAuthentication(from, "asysdorgmwguddej");

			}

		});
		
		//Session session = Session.getDefaultInstance(props);
		
		//����MimeMessageʵ������
		MimeMessage msg=new MimeMessage(session);
		//���÷�����
		msg.setFrom(new InternetAddress(from));
		//�����ռ���
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		//���÷�������
		msg.setSentDate(new Date());
		//�����ʼ�����
		msg.setSubject(subject);
		//���ô��ı����ݵ��ʼ�����
		msg.setContent(body2, "text/html;charset=UTF-8");
		//msg.setText(body);
		//����Ϊdebugģʽ�����Բ鿴��ϸ�ķ���1og
		session.setDebug(true);
		Transport.send(msg);
		  
//		 // ��ȡTransport����
//		  Transport transport = session.getTransport("smtp");
//		  // ��2��������Ҫ��д����QQ�����SMTP����Ȩ��
//		  transport.connect(from,"asysdorgmwguddej");
//		  // ���ͣ�message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
//		  transport.sendMessage(msg, msg.getAllRecipients());
//		  transport.close();
		
		
	
			


	}

//����HTML��ʽ���ʼ����ģ�+���ı����ģ�
	@Test(enabled=false)
	public void send_Html() throws Exception {
		String from="2798011643@qq.com";
		String to="2798011643@qq.com";
		String subject="html test";
		String body="<!DOCTYPE html><html><head><title></title><meta charset=\"utf-8\"><style type=\"text/css\">\r\n" + 
				"		#123{font-weight: 100;\r\n" + 
				"			font-style: italic;\r\n" + 
				"		}\r\n" + 
				"		.456{font-weight: 900;\r\n" + 
				"			font-style: italic;\r\n" + 
				"		}\r\n" + 
				"	</style></head><body>\r\n" + 
				"<div id=\"123\">\r\n" + 
				"	<div class=\"456\">\r\n" + 
				"		<p>����褻����·���Ƿ���</p>\r\n" + 
				"	</div></div></body></html>";
		String body2="dewfeqr";
		String smtpHost = "smtp.qq.com";
		String port="25";
		// ����һ��Property�ļ�����
		Properties props = new Properties();
		// ʹ�õ�Э�飨JavaMail�淶Ҫ��
		props.put("mail.transport.protocol", "smtp");
		// �����ʼ�����������Ϣ����������smtp��������
		props.put("mail.smtp.host", smtpHost);
		// ����socket factory �Ķ˿�
		props.put("mail.smtp.socketFactory.port", "465");
		// ����socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		// ������Ҫ�����֤
		props.put("mail.smtp.auth", "true");
		// ����SMTP�Ķ˿ڣ�QQ��smtp�˿���25
		props.put("mail.smtp.port", port);
		
		//����Sessionʵ������
		Session session = Session.getInstance(props, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
                       // �ڶ���������������QQ����smtp����Ȩ��
			   return new PasswordAuthentication(from, "asysdorgmwguddej");

			}

		});
		
		//����MimeMessageʵ������
		MimeMessage msg=new MimeMessage(session);
		//���÷�����
		msg.setFrom(new InternetAddress(from));
		//�����ռ���
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		//���÷�������
		msg.setSentDate(new Date());
		//�����ʼ�����
		msg.setSubject(subject);
		//����һ��MimeBodyPart�Ķ����Ա��������
		BodyPart mimeBodyPart=new MimeBodyPart();
		//���HTML��ʽ�ʼ�����
		mimeBodyPart.setContent(body,"text/html;charset=gb2312");
		//BodyPart mimeBodyPart2=new MimeBodyPart();
		//���ı�����
		mimeBodyPart.setText(body2);
		// ����һ��MimeMultipart���ʵ������
		MimeMultipart mimeMultipart=new MimeMultipart();
		// �����������
		mimeMultipart.addBodyPart(mimeBodyPart);
		//mimeMultipart.addBodyPart(mimeBodyPart2);
		// ��������
	    msg.setContent(mimeMultipart);
		// ���շ����ʼ�
		Transport.send(msg);

	}
	
//���ʹ��������ʼ�	
	@Test(enabled=false)
	public void send_File() throws Exception {
		String from="2798011643@qq.com";
		String to="2798011643@qq.com";
		String subject="html test";
		String body="<!DOCTYPE html><html><head><title></title><meta charset=\"utf-8\"><style type=\"text/css\">\r\n" + 
				"		#123{font-weight: 100;\r\n" + 
				"			font-style: italic;\r\n" + 
				"		}\r\n" + 
				"		.456{font-weight: 900;\r\n" + 
				"			font-style: italic;\r\n" + 
				"		}\r\n" + 
				"	</style></head><body>\r\n" + 
				"<div id=\"123\">\r\n" + 
				"	<div class=\"456\">\r\n" + 
				"		<p>����褻����·���Ƿ���</p>\r\n" + 
				"	</div></div></body></html>";
		String body2="dewfeqr";
		String smtpHost = "smtp.qq.com";
		String port="25";
		// ����һ��Property�ļ�����
		Properties props = new Properties();
		// ʹ�õ�Э�飨JavaMail�淶Ҫ��
		props.put("mail.transport.protocol", "smtp");
		// �����ʼ�����������Ϣ����������smtp��������
		props.put("mail.smtp.host", smtpHost);
		// ����socket factory �Ķ˿�
		props.put("mail.smtp.socketFactory.port", "465");
		// ����socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		// ������Ҫ�����֤
		props.put("mail.smtp.auth", "true");
		// ����SMTP�Ķ˿ڣ�QQ��smtp�˿���25
		props.put("mail.smtp.port", port);
		
		//����Sessionʵ������
		Session session = Session.getInstance(props, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
                       // �ڶ���������������QQ����smtp����Ȩ��
			   return new PasswordAuthentication(from, "asysdorgmwguddej");

			}

		});
		
		//����MimeMessageʵ������
		MimeMessage msg=new MimeMessage(session);
		//���÷�����
		msg.setFrom(new InternetAddress(from));
		//�����ռ���
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		//���÷�������
		msg.setSentDate(new Date());
		//�����ʼ�����
		msg.setSubject(subject);
		//����һ��MimeBodyPart�Ķ����Ա��������
		BodyPart mimeBodyPart=new MimeBodyPart();
		//���HTML��ʽ�ʼ�����
		//mimeBodyPart.setContent(body,"text/html;charset=gb2312");
		//���ı�����
		mimeBodyPart.setText(body2);
		
		//MimeBodyPart����2,��Ÿ���
		BodyPart mimeBodyPart2=new MimeBodyPart();
		// �����ʼ��и����ļ���·��
		String filename = "G:\\web\\work\\6-2.html";
		// ����һ��datasource���󣬲������ļ�
		DataSource source = new FileDataSource(filename);
		//����handler
		mimeBodyPart2.setDataHandler(new DataHandler(source));
		// �����ļ�
		mimeBodyPart2.setFileName(filename);

		// ����һ��MimeMultipart���ʵ������
		MimeMultipart mimeMultipart=new MimeMultipart();
		// �����������
		mimeMultipart.addBodyPart(mimeBodyPart);
		mimeMultipart.addBodyPart(mimeBodyPart2);
		// ��������
	    msg.setContent(mimeMultipart);
		// ���շ����ʼ�
		Transport.send(msg);

	}

	MailClass mc=new MailClass();
	
    @Test(dataProvider="address",dataProviderClass=NSDataProvider.class)
    public void test(String address) throws AddressException, MessagingException {
    	String subjects="123";
    	String file = "G:\\web\\work\\6-2.html";
    	mc.send_File(address, subjects, file);
    }
}
