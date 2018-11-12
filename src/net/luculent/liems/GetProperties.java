package net.luculent.liems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class GetProperties {
	private String value=null;
	public String getProperties(String key,String path){
		try {
			FileInputStream  fi=new FileInputStream(path);
			Properties pro=new Properties();
			try {
				pro.load(fi);
				value=pro.getProperty(key);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("�ļ�����ʧ��");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("�ļ�������");
			e.printStackTrace();
		}
		return value;
		
	}
	

}
