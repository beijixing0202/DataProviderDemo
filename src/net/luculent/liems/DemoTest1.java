package net.luculent.liems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class DemoTest1 {
	@Test(timeOut=1)
	public void testsub(){
		long i=1;
		long sum = 0;
		while(i<922337280){
			sum=i++;
		}
		System.out.println(sum);
	}
	@Test
	public void test1(){
		System.out.println("test1...");
	}
	
	@Test
	public void test2(){
		System.out.println("test2...");
	}
	
	@Test(dependsOnMethods={"test4","test1","test2"})
	public void test3(){
		System.out.println("test3...");
	}
	
	@Test
	public void test4(){
		System.out.println("test4...");
	}
	
	@Test
	public void getvalue(){
		try {
			FileInputStream fi=new FileInputStream("db.properties");
			Properties pro=new Properties();
			try {
				pro.load(fi);
				String user=pro.getProperty("username");
				String pwd=pro.getProperty("password");
				String url=pro.getProperty("url");
				System.out.println("ÓÃ»§Ãû"+user+" "+"ÃÜÂë£º"+pwd);
				System.out.println("URL:"+url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	@Test(parameters={ "first-name"})
	public void test5(String username){
		System.out.println(username);
	}
	
	@DataProvider(name="data1")
	public Object[][] createdata(){
		return new Object[][]{
				{"lilei",20,"football"},
				{"hanmeimei", 18, "music"},
				{"wangnima", 25, "baozoumanhua"}
		};
	}
	
	@Test(dataProvider="data1")
	public void test6(String name, int age, String hobby){
		System.out.println(name + " is " + age + " years old and likes " );
	}
}
