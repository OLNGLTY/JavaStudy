package com.zhao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * ��������Mysql
 * @author Hai
 *
 */
public class MysqlUtil {
	private static Connection con = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");//�������ݿ�
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qunliao","root","1002");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private MysqlUtil(){}
	public static Connection getInstace(){
		return con;
	}
}
