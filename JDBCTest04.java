//���������ݿ��������Ϣ���õ������ļ���
/*
	ʵ�ʿ����в�������������ݿ����Ϣд����java�����С�
*/
import java.sql.*;
import java.util.*;

public class JDBCTest04{
	public static void main(String[] args){

		// ʹ����Դ���������������ļ�
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");

		Connection conn = null;
		Statement stmt = null;
		try{
			//1��ע������
			Class.forName(driver);
			//2����ȡ����
			conn = DriverManager.getConnection(url,user,password);
			//3����ȡ���ݿ��������
			stmt = conn.createStatement();
			//4��ִ��SQL���			
			String sql = "update dept set dname = '���۲�2', loc = '���2' where deptno = 20";
			int count = stmt.executeUpdate(sql);
			System.out.println(count == 1 ? "�޸ĳɹ�" : "�޸�ʧ��");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//6���ͷ���Դ
			if(stmt != null){
				try{
					stmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}	
			}
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}	
			}
		}
	}
}