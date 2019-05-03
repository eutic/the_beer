package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	public static Connection getConnection() {
		/*Connection conn = null;
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/aws_h07");
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;*/
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 클래스 적재
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@54.180.2.212:1521:xe", "newboard", "1234");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	// select 수행 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement pstmt, ResultSet rs) {
		try {
			if(conn!=null) conn.close();
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
		// CUD 수행 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement pstmt) {
		try {
			if(conn!=null)conn.close();
			if(pstmt!=null)pstmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
