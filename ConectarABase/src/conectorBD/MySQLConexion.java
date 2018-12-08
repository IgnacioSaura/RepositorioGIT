package conectorBD;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;



public class MySQLConexion {

	public static Connection connection;
	
	public static Connection getConnection() {
		try {
			if(connection == null) {
				Runtime.getRuntime().addShutdownHook(new getClose());
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306//escuela","root","root");
			
			}
			return connection;
			} catch (ClassNotFoundException | SQLException e) {
				throw new RuntimeException("Conexion fallida", e);
	}			
}
	static class getClose extends Thread{
		@Override
		public void run() {
			try {
				Connection conn = MySQLConexion.getConnection();
				conn.close();
			} catch (SQLException ex) {
				
			throw new RuntimeException(ex);
			}
		}
	}
	}
	
