/*
	JDBC�������
*/
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class JDBCTest01{
	public static void main(String[] args){
		Connection conn = null;
		Statement stmt = null;
		try{
			//1��ע������
			Driver driver = new com.mysql.jdbc.Driver(); // ��̬������������ָ�������Ͷ���
			// Driver driver = new oracle.jdbc.driver.OracleDriver(); // oracle��������
			DriverManager.registerDriver(driver);
			//2����ȡ����
			/*
				url��ͳһ��Դ��λ����������ĳ����Դ�ľ���·����
				https://www.baidu.com/ �����URL��
				URL�����ļ����֣�
					Э��
					IP
					PORT
					��Դ��

				http://182.61.200.7:80/index.html
					http:// ͨ��Э��
					182.61.200.7 ������IP��ַ
					80 ������������Ķ˿�
					index.html �Ƿ�������ĳ����Դ��
				
				
				jdbc:mysql://127.0.0.1:3306/bjpowernode
					jdbc:mysql:// Э��
					127.0.0.1 IP��ַ
					3306 mysql���ݿ�˿ں�
					bjpowernode ��������ݿ�ʵ������
				
				˵����localhost��127.0.0.1���Ǳ���IP��ַ��

				jdbc:mysql://192.168.151.27:3306/bjpowernode
				
				ʲô��ͨ��Э�飬��ʲô�ã�
					ͨ��Э����ͨ��֮ǰ����ǰ���õ����ݴ��͸�ʽ��
					���ݰ�������ô�����ݣ���ʽ��ǰ���õġ�
				
				oracle��URL��
					jdbc:oracle:thin:@localhost:1521:orcl
			*/
			String url = "jdbc:mysql://192.168.151.9:3306/bjpowernode";
			String user = "root";
			String password = "981127";
			conn = DriverManager.getConnection(url,user,password);
			// com.mysql.jdbc.JDBC4Connection@41cf53f9
			System.out.println("���ݿ����Ӷ��� = " + conn); 

			//3����ȡ���ݿ��������(Statementר��ִ��sql����)
			stmt = conn.createStatement();

			//4��ִ��sql
			String sql = "insert into dept(deptno,dname,loc) values(50,'���²�','����')";
			// ר��ִ��DML����(insert delete update)
			// ����ֵ�ǡ�Ӱ�����ݿ��еļ�¼������
			int count = stmt.executeUpdate(sql); 
			System.out.println(count == 1 ? "����ɹ�" : "����ʧ��");

			//5�������ѯ�����

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			//6���ͷ���Դ
			// Ϊ�˱�֤��Դһ���ͷţ���finally�����йر���Դ
			// ����Ҫ��ѭ��С�������ιر�
			// �ֱ����try..catch
			try{
				if(stmt != null){
					stmt.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				if(conn != null){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}