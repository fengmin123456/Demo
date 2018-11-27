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

public class MailClass {
	
	public void send_Text(String address,String subjects,String message) throws AddressException, MessagingException {

		String from="2798011643@qq.com";
		String to=address;
		String subject=subjects;
		String body=message;
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
		msg.setText(message);
//		//����һ��MimeBodyPart�Ķ����Ա��������
//		BodyPart mimeBodyPart=new MimeBodyPart();
//		//���ı�����
//		mimeBodyPart.setText(body);
//		// ����һ��MimeMultipart���ʵ������
//		MimeMultipart mimeMultipart=new MimeMultipart();
//		// �����������
//		mimeMultipart.addBodyPart(mimeBodyPart);
//		// ��������
//	    msg.setContent(mimeMultipart);
		// ���շ����ʼ�
		Transport.send(msg);
	}

	public void send_Html(String address,String subjects,String message) throws AddressException, MessagingException {
		String from="2798011643@qq.com";
		String to="2798011643@qq.com";
		String subject=subjects;
		String body=message;
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
		// ����һ��MimeMultipart���ʵ������
		MimeMultipart mimeMultipart=new MimeMultipart();
		// �����������
		mimeMultipart.addBodyPart(mimeBodyPart);
		// ��������
	    msg.setContent(mimeMultipart);
		// ���շ����ʼ�
		Transport.send(msg);
	}

	public void send_File(String address,String subjects,String file) throws AddressException, MessagingException {
		String from="2798011643@qq.com";
		String to=address;
		String subject=subjects;
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
		//MimeBodyPart����,��Ÿ���
		BodyPart mimeBodyPart=new MimeBodyPart();
		// �����ʼ��и����ļ���·��
		String filename = file;
		// ����һ��datasource���󣬲������ļ�
		DataSource source = new FileDataSource(filename);
		//����handler
		mimeBodyPart.setDataHandler(new DataHandler(source));
		// �����ļ�
		mimeBodyPart.setFileName(filename);
		// ����һ��MimeMultipart���ʵ������
		MimeMultipart mimeMultipart=new MimeMultipart();
		// �����������
		mimeMultipart.addBodyPart(mimeBodyPart);
		// ��������
		msg.setContent(mimeMultipart);
		// ���շ����ʼ�
		Transport.send(msg);
	}
	
    public void send_TextFile(String address,String subjects,String message,String file) throws AddressException, MessagingException {
		String from="2798011643@qq.com";
		String to=address;
		String subject=subjects;
		String body=message;
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
		//���ı�����
		mimeBodyPart.setText(body);
		//MimeBodyPart����2,��Ÿ���
		BodyPart mimeBodyPart2=new MimeBodyPart();
		// �����ʼ��и����ļ���·��
		String filename = file;
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
	
	public void send_HtmlFile(String address,String subjects,String message,String file) throws AddressException, MessagingException {
		String from="2798011643@qq.com";
		String to=address;
		String subject=subjects;
		String body=message;
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
		//MimeBodyPart����2,��Ÿ���
		BodyPart mimeBodyPart2=new MimeBodyPart();
		// �����ʼ��и����ļ���·��
		String filename = file;
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

	
}
