/**
 * 
 */
package net.luculent.liems;

import java.lang.reflect.Method;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

/**
 * @author shengyuan.wang
 *
 */
public class DataProviderTest {
	@DataProvider
	public Object[][] providerMethod(Method method){
		Object[][] result=null;
		if(method.getName().equalsIgnoreCase("testmethod1")){
			
			result=new Object[][]{new Object[]{3,2}};
		}else if(method.getName().equalsIgnoreCase("testmethod2")){
			
			result=new Object[][]{new Object[]{2}};
		}else{
			result=new Object[][]{new Object[]{3}};
		}
		return result;
	}
	
	@Test(dataProvider="providerMethod")
	public void testmethod1(int param,int param2){
		System.out.println("method1 received:"+param+"  ²ÎÊý2£º"+param2);
	}

	@Test(dataProvider="providerMethod")
	public void testmethod2(int param){
		System.out.println("method1 received:"+param);
	}
	
	@Test(dataProvider="providerMethod")
	public void testmethod3(int param){
		System.out.println("method1 received:"+param);
	}
	
	@Test
	public void test1(){
		double[] mylist={1.9, 2.9, 3.4, 3.5};
		for(double element:mylist){
			System.out.println(element);
		}
		
	}
	
}
