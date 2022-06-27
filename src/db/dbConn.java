package db;

import java.sql.*;

/**
 *
 * Title: 数据库连接
 * Description: 数据库连接模块
 *
 * @author JAVA设计
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
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");

			// 数据库名称，管理员账号、密码
//			String url = "jdbc:mysql://localhost:3306/stumanagerdb";
			String url = "jdbc:mysql://localhost:3306/stumanagerdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_demo?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","password");

			String user = "root";
			String pwd = "root";

			// 连接
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

	// 查询数据库
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

	// 更新数据库
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
