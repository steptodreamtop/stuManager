package db;

import java.sql.*;

/**
 *
 * Title: ���ݿ�����
 * Description: ���ݿ�����ģ��
 *
 * @author JAVA���
 */

public class dbConn {
	public dbConn() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Statement conn() {
		try {
			// ��������
			Class.forName("com.mysql.jdbc.Driver");

			// ���ݿ����ƣ�����Ա�˺š�����
//			String url = "jdbc:mysql://localhost:3306/stumanagerdb";
			String url = "jdbc:mysql://localhost:3306/stumanagerdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_demo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","password");

			String user = "root";
			String pwd = "root";

			// ����
			Connection con = null;
			try {
				con = DriverManager.getConnection(url, user, pwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Statement stat = con.createStatement();
			return stat;
		} catch (ClassNotFoundException ex) {
			return null;
		} catch (SQLException ex1) {
			return null;
		}
	}

	// ��ѯ���ݿ�
	public ResultSet getRs(String sql) {
		try {
			Statement stat = conn();
			ResultSet rs = stat.executeQuery(sql);
			System.out.println(rs);
			return rs;
		} catch (SQLException ex) {
			System.err.println("------------" + ex.getMessage());
			return null;
		}
	}

	// �������ݿ�
	public int getUpdate(String sql) {
		try {
			Statement stat = conn();
			int i = stat.executeUpdate(sql);
			return i;
		} catch (Exception ex) {
			System.out.println(">>>>>>>>" + ex.getMessage());
			return -1;
		}
	}

	private void jbInit() throws Exception {
		conn();
	}

}
