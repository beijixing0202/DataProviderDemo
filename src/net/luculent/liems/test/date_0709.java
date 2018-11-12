package net.luculent.liems.test;

import java.io.IOException;

import net.luculent.liems.GetProperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class date_0709 {
	private WebDriver driver;
    GetProperties getProperties=new GetProperties();
  
   
    @Parameters({"path"})
	@BeforeMethod
	public void init(String path){
		System.setProperty(getProperties.getProperties("IEdriver", path), getProperties.getProperties("IEdriverPath", path));
		driver=new InternetExplorerDriver();	
	}
    
	
	@Test
	public void test1(){
		//driver.navigate().to("http://www.baidu.com");
		driver.get("http://www.baidu.com");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@AfterMethod
	public void end(){
		System.out.println("======¿ªÊ¼Ö´ÐÐAafterMethod========");
		driver.close();
		try {
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
