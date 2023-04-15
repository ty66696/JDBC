/*
	�����ѯ��������������������
*/
import java.sql.*;

public class JDBCTest05{
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			//1��ע������
			Class.forName("com.mysql.jdbc.Driver");
			//2����ȡ����
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","333");
			//3����ȡ���ݿ��������
			stmt = conn.createStatement();
			//4��ִ��sql
			String sql = "select empno as a,ename,sal from emp";
			// int executeUpdate(insert/delete/update)
			// ResultSet executeQuery(select)
			rs = stmt.executeQuery(sql); // ר��ִ��DQL���ķ�����
			//5�������ѯ�����
			/*
			boolean flag1 = rs.next();
			//System.out.println(flag1); // true
			if(flag1){
				// ���ָ�����������
				// ȡ����
				// getString()�������ص��ǣ��������ݿ��е�����������ʲô������String����ʽȡ����
				String empno = rs.getString(1); // JDBC�������±��1��ʼ�����Ǵ�0��ʼ��
				String ename = rs.getString(2);
				String sal = rs.getString(3);
				System.out.println(empno + "," + ename + "," + sal);
			}

			flag1 = rs.next();
			if(flag1){
				// ���³����1 2 3 ˵�ĵڼ��С�
				String empno = rs.getString(1);
				String ename = rs.getString(2);
				String sal = rs.getString(3);
				System.out.println(empno + "," + ename + "," + sal);
			}
			*/

			while(rs.next()){
				/*
				String empno = rs.getString(1);
				String ename = rs.getString(2);
				String sal = rs.getString(3);
				System.out.println(empno + "," + ename + "," + sal);
				*/

				/*
				// ����������е��±��ȡ�����е����ֻ�ȡ
				//String empno = rs.getString("empno");
				String empno = rs.getString("a"); // �ص�ע�⣺�����Ʋ��Ǳ��е������ƣ��ǲ�ѯ������������ơ�
				String ename = rs.getString("ename");
				String sal = rs.getString("sal");
				System.out.println(empno + "," + ename + "," + sal);
				*/

				// ���˿�����String����ȡ��֮�⣬���������ض�������ȡ����
				/*
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				double sal = rs.getDouble(3);
				System.out.println(empno + "," + ename + "," + (sal + 100));
				*/

				int empno = rs.getInt("a");
				String ename = rs.getString("ename");
				double sal = rs.getDouble("sal");
				System.out.println(empno + "," + ename + "," + (sal + 200));
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//6���ͷ���Դ
			if(rs != null){
				try{
					rs.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(stmt != null){
				try{
					stmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}