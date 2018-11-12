package net.luculent.liems.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.mysql.jdbc.PreparedStatement;

public class jdbcTest {
	private static String URL="jdbc:mysql://192.168.9.160:18066/mas";
	private static String USER="ma_user";
	private static String PASSWORD="mas123";
	private static Connection conn=null;
	
	@Test
	public void test1() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(URL, USER, PASSWORD);
		String sql="SELECT * FROM t_txn_ctrl  WHERE  id_txn='14496938'";
		PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			System.out.println(rs.toString());
		}
		
		rs.close();
		pst.close();
		conn.close();
		
	}
	

}
