package Test0512;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Test01 {

	public static void main(String[] args) {
		Connection con;
		String url = "jdbc:mysql://localhost:3306/zhao";
		String user = "root";
		String password = "1002";
		try {
			//������������
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ�
			con = DriverManager.getConnection(url,user,password);
			//����statement��������ִ��SQL���
			Statement statement = con.createStatement();
			String sql = "select * from list";
			//ResultSet�࣬������Ż�ȡ�Ľ����
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("-----------------");
			System.out.println("ִ�н��������ʾ:");  
			System.out.println("-----------------");  
			System.out.println("���" + "\t" + "����");  
			System.out.println("-----------------");
			while(rs.next()){
				System.out.println(rs.getString("id")+"\t"+rs.getString("name"));
			}
			rs.close();
			con.close();
			PreparedStatement psql;
//			ResultSet res;
			//����
//			psql = con.prepareStatement("insert into list (id,name) " + "values(?,?)");
//			psql.setInt(1, 1);
//			psql.setString(2, "zhaoqinghai");
//			psql.executeUpdate();
			//����
//			psql = con.prepareStatement("update list set name = ? where id = ?");
//			psql.setString(1, "zhaoqinghai");
//			psql.setInt(2, 2);
//			psql.executeUpdate();
			//ɾ��
//			psql = con.prepareStatement("delete from list where id = ?");
//			psql.setInt(1, 1);
//			psql.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
