package com.edu.core;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtil {
	static int port = 25;

    static String server = "smtp.qq.com";
    static String file=PicSend.Zip();
    static String from = "�����";
    static String user = "2798011643@qq.com";
    static String password = "asysdorgmwguddej";

    



    public static void sendEmail(String email, String subject, String body,String file) throws UnsupportedEncodingException {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", server);
            props.put("mail.smtp.port", String.valueOf(port));
            props.put("mail.smtp.auth", "true");
            Transport transport = null;
            Session session = Session.getDefaultInstance(props,null);
            transport = session.getTransport("smtp");
            transport.connect(user, password);
            MimeMessage msg = new MimeMessage(session);
            msg.setSentDate(new Date());
            
            InternetAddress fromAddress = new InternetAddress(user,from,"UTF-8");
            msg.setFrom(fromAddress);
            String emailList[]=email.split(",");
            InternetAddress[] toAddress = new InternetAddress[emailList.length];
            
            for(int i=0;i<emailList.length;i++)
            {
            	toAddress[i]=new InternetAddress(emailList[i]);
            }
            //msg.setRecipients(Message.RecipientType.TO, toAddress);
            msg.addRecipients(Message.RecipientType.TO, toAddress);
            msg.setSubject(subject, "UTF-8");   
            
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
            
    		//����һ��MimeBodyPart�Ķ����Ա��������
    		BodyPart mimeBodyPart2=new MimeBodyPart();
    		//���HTML��ʽ�ʼ�����
    		mimeBodyPart2.setContent(body,"text/html;charset=utf-8");
    		
    		// ����һ��MimeMultipart���ʵ������
    		MimeMultipart mimeMultipart=new MimeMultipart();
    		// �����������
    		// �����������
    		mimeMultipart.addBodyPart(mimeBodyPart);
    		mimeMultipart.addBodyPart(mimeBodyPart2);
    		// ��������
    		msg.setContent(mimeMultipart);
            msg.saveChanges();
            transport.sendMessage(msg, msg.getAllRecipients());
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static String getTime()
    {
    	java.util.Calendar c=java.util.Calendar.getInstance();    
        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyyMMdd");    
       	return  f.format(c.getTime());    
    }

}
