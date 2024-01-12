package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao {
	
	private String url;
	private String user;
	private String pass;
	private static Connection con;
	
	public EmployeeDao() {
		//接続先url
		this.url = "jdbc:oracle:thin:@localhost:1521:xe";
		//ユーザー名
		this.user = "LESSON";
		//pass
		this.pass = "oracle";
		
		try {
			if(con == null) {
				//接続
				con = DriverManager.getConnection(this.url, this.user, this.pass);
				//自動コミット設定
				con.setAutoCommit(true);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(String name, String department) {
		//INSERT文
		String sql = "INSERT INTO EMPLOYEES (ID, NAME, DEPARTMENT) VALUES (EMPLOYEE_ID_SEQ.nextval,?,?)";
		
		//SQL文
		try(PreparedStatement stmt = con.prepareStatement(sql);) {
			//SQL文に引数
			stmt.setString(1, name); //nameカラム
			stmt.setString(2,  department);
			//SQL実行
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
