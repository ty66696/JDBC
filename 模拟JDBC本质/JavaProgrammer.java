
/*
	Java����Ա��ɫ��
	����Ҫ���ľ������ĸ�Ʒ�Ƶ����ݿ⣬ֻ��Ҫ����JDBC�ӿ�д���롣
	����ӿڱ�̣���������̣���Ҫ��������̡�
*/
import java.util.*;

public class JavaProgrammer
{
	public static void main(String[] args) throws Exception{
		// JDBC jdbc = new MySQL();
		// JDBC jdbc = new SqlServer();

		// �����������ͨ��������ơ�
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String className = bundle.getString("className");
		Class c = Class.forName(className);
		JDBC jdbc = (JDBC)c.newInstance();

		// ���´��붼������ӿڵ��÷���������Ҫ�޸�
		jdbc.getConnection();
	}
}