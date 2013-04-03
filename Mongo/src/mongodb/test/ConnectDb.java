package mongodb.test;

import java.sql.*;

public class ConnectDb {
	String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String connectionURL = "jdbc:sqlserver://127.0.0.1:1433";
	String dbUser = "maxsabba";
	String dbPwd = "tr1llina";
	
	private static ConnectDb connectDb = null;
	
	private ConnectDb(){
		try {
			Class.forName(driverClassName);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnectionMSSQL()throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionURL,dbUser,dbPwd);
		return conn;
		
	}
	
	public static ConnectDb getInstance() {
		if (connectDb == null) {
			connectDb = new ConnectDb();
		}
		return connectDb;
		
	}
			

}
