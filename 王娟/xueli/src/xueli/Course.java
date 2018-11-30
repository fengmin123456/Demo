package xueli;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Course {
		@Test
		public void course()throws InterruptedException{
			//��ѩ��
			System.setProperty("webdriver.gecko.driver", "F:\\qudong\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "F:\\firefox\\firefox.exe");
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://10.7.10.7/");
			Thread.sleep(1000);
			//��¼�˺�
			driver.findElement(By.xpath("//a[contains(.,'��¼')]")).click();
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("741852@qq.com");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("LAla852");
			driver.findElement(By.xpath("//button[contains(.,'��¼')]")).click();
			
			//���ͬ����
			driver.findElement(By.xpath("//a[@href='/team/']")).click();
			//�������ͬ����
			driver.findElement(By.xpath("//button[@data-team='da-xue-ying-yu']")).click();
			driver.findElement(By.xpath("//input[@maxlength='20']")).sendKeys("����");
			driver.findElement(By.xpath("//button[contains(.,'�������')]")).click();
			Thread.sleep(1000);
			//�������ͬ����
			driver.findElement(By.xpath("//h1[contains(.,'2016ѩ��ʵѵ��Ŀ')]")).click();
			driver.findElement(By.xpath("//span[contains(.,' ��Ա')]")).click();
			driver.findElement(By.xpath("//h5[@title='8-������']")).click();
			driver.findElement(By.xpath("//button[@id='id_fans']")).click();
			Thread.sleep(1000);
			//����ͬ����
			driver.findElement(By.xpath("//input[@id='q']")).sendKeys("��ѧӢ��");
			driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
			Thread.sleep(1000);
//			//�鿴�Ѽ����ͬ����
//			driver.findElement(By.xpath("//a[contains(.,'��ҳ')]")).click();
//			driver.findElement(By.xpath("//a[@href='/u/teams/']")).click();
//			driver.findElement(By.xpath("//p[contains(.,'�й�����ʷ')]")).click();
//			driver.findElement(By.xpath("//span[contains(.,' ����')]")).click();
//			//���뻰��
//			driver.findElement(By.xpath("//a[@title='����#����#']")).click();
//			driver.findElement(By.xpath("//button[contains(.,'����')]")).click();
			
		}
		
		@Test
		public void mail() {
			
			// ����һ��Property�ļ�����
			Properties props = new Properties();
	 
			// �����ʼ�����������Ϣ����������smtp��������
			props.put("mail.smtp.host", "smtp.qq.com");
	 
			// ����socket factory �Ķ˿�
			props.put("mail.smtp.socketFactory.port", "465");
	 
			// ����socket factory
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	 
			// ������Ҫ�����֤
			props.put("mail.smtp.auth", "true");
	 
			// ����SMTP�Ķ˿ڣ�QQ��smtp�˿���25
			props.put("mail.smtp.port", "25");
	 
			// �����֤ʵ��
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	 
				protected PasswordAuthentication getPasswordAuthentication() {
	                        // �ڶ���������������QQ����smtp����Ȩ��
				return new PasswordAuthentication("2402370100@qq.com", "dphmoghxcmvvdjge");
	 
				}
	 
			});
	 
			try {
	 
				// ����һ��MimeMessage���ʵ������
				Message message = new MimeMessage(session);
	 
				// ���÷����������ַ
				message.setFrom(new InternetAddress("2402370100@qq.com"));
	 
				// �����ռ��������ַ
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("2402370100@qq.com"));
	            
	            // �����ʼ�����
				message.setSubject("���Ա���");
	 
				// ����һ��MimeBodyPart�Ķ����Ա��������
				BodyPart messageBodyPart1 = new MimeBodyPart();
	 
				// �����ʼ���������
				messageBodyPart1.setText("���Ĳ���");
	 
				// ��������һ��MimeBodyPart�����Ա������������
				MimeBodyPart messageBodyPart2 = new MimeBodyPart();
	 
				// �����ʼ��и����ļ���·��
				String filename = ".\\test-output\\index.html";
	 
				// ����һ��datasource���󣬲������ļ�
				DataSource source = new FileDataSource(filename);
	 
				// ����handler
				messageBodyPart2.setDataHandler(new DataHandler(source));
	 
				// �����ļ�
				messageBodyPart2.setFileName(filename);
	 
				// ����һ��MimeMultipart���ʵ������
				Multipart multipart = new MimeMultipart();
	 
				// �������1����
				multipart.addBodyPart(messageBodyPart1);
	 
				// �������2����
				multipart.addBodyPart(messageBodyPart2);
	 
				// ��������
				message.setContent(multipart);
	 
				// ���շ����ʼ�
				Transport.send(message);
	 
				System.out.println("=====�ʼ��Ѿ�����=====");
	 
			} catch (MessagingException e) {
	 
				   throw new RuntimeException(e);
	 
			}
	 
		}
		
}
