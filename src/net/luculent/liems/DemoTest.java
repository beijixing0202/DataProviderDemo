package net.luculent.liems;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTest {
	@BeforeClass
	public static void beforeClass(){
		System.out.println("before class test...");
	}
	@BeforeMethod
	public void beforeTest(){
		System.out.println("before test...");
	}
	@Test
	public void testadd(){
		System.out.println("testadd");
	}
	@Test
	public void testsub(){
		System.out.println("testsub");
	}
	@AfterMethod
	public void aftertest(){
		System.out.println("after test...");
	}
	@AfterClass
	public static void afterClass(){
		System.out.println("after class...");
	}

}
