package net.luculent.liems;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo1 {
	//������
	@DataProvider(name="data")
	public Iterator<Object[]> dataForTestMethod(Method method) throws FileNotFoundException{
		return (Iterator<Object[]>) new ExcelDataProvider(this.getClass().getSimpleName(), method.getName());
	}

	@Test(dataProvider="data")
	public void interfaceTest(Map<String,String> map){
		String caseName=map.get("��������");
		String xieyi = map.get("Э��");
        System.out.println("caseName:"+caseName+"  xieyi:"+xieyi);
	}

}
