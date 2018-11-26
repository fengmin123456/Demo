package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;


//�����������������Կ�����
@Listeners({ WebTestListener.class })
public class Login extends BaseTest{
	Login_Action action;
	
	@BeforeMethod
	public void setup()
	{
		action=new Login_Action(webtest);
	}

	//����txt����·��
	 private static final String fileName="data\\name.txt";
	@Test(dataProvider="data")
	//��txt������������ȷ���û����������¼
	public void loginSuccess(String s1,String s2) throws Exception  {
		webtest.open("http://10.7.10.7/");
		action.login(s1, s2);
				
		//�ж��Ƿ��¼�ɹ�,���ɹ���������ɹ�����Ϣ
		boolean str=webtest.panduan("xpath=html/body/header/nav/div[2]/ul/li[1]/a");
		if(str==true) {
			//�ƶ�һ�����
			webtest.mouseLong();
			webtest.mouseoverElement("xpath=//a[@class='avatar']");
			//��������б�
			webtest.click("link=�˳�");
		}else {
			System.out.println("δ�ܳɹ���¼");
		}
		
	}
	
	@Test
	//��¼ʧ������
	public void loginfail() throws InterruptedException {
		webtest.open("http://10.7.10.7/");
		webtest.click("link=��¼");
		webtest.type("xpath=.//*[@id='id_username']", "13364191@qq.com");
		webtest.type("id=id_password","ZHANGyu123");
		webtest.click("id=submit");
		
		//�ж��Ƿ��¼�ɹ�,���ɹ���������ɹ�����Ϣ
				boolean str=webtest.panduan("xpath=html/body/header/nav/div[2]/ul/li[1]/a");
				//�����¼�ɹ����˳�����¼ʧ�ܾͽ�ͼ
				if(str==true) {
					//�ƶ�һ�����
					webtest.mouseLong();
					webtest.mouseoverElement("xpath=//a[@class='avatar']");
					//��������б�
					webtest.click("link=�˳�");
				}else {
					System.out.println("δ�ܳɹ���¼");
				}
				
	}
	
	
	
	
	
	//����Ϊ����������
	@DataProvider(name="data")
	public static Object[][] getData() throws IOException{
		return getTestData(fileName);
	}
	//��ȡtxt����
	public static Object[][] getTestData(String filepath) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filepath), "GBK"));
		
		 String s=null;

	       List<Object[]> listData=new ArrayList<Object[]>();

	       while ((s=br.readLine())!=null) {

	         listData.add(s.split(","));

	         System.out.println(s.split(",")[0].toString());

	      }

	       br.close();

	       Object[][]results=new Object[listData.size()][];

	       for(int i=0;i<listData.size();i++)

	       {

	          results[i]=listData.get(i);

	          System.out.println(results[i][0].toString());

	       }

	       return results;
		
	}


}
