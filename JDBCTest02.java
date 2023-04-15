/*
	JDBC���delete update
*/
import java.sql.*;

public class JDBCTest02{
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		try{
			//1��ע������
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//2����ȡ����
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","333");
			//3����ȡ���ݿ��������
			stmt = conn.createStatement();
			//4��ִ��SQL���			
			// String sql = "delete from dept where deptno = 40";
			// JDBC�е�sql��䲻��Ҫ�ṩ�ֺŽ�β��
			String sql = "update dept set dname = '���۲�', loc = '���' where deptno = 20";
			int count = stmt.executeUpdate(sql);
			System.out.println(count == 1 ? "�޸ĳɹ�" : "�޸�ʧ��");
		}catch(SQLException e){
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