package empportal;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
	public static Connection getconnection() throws Exception{
		try {
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost/web_portal";
			String user="root";
			String pass="qwerty";
			Class.forName(driver);
			
			Connection conn= DriverManager.getConnection(url,user,pass);
			return conn;
		}catch(Exception e) {System.out.println(e);}
		return null;
	}

}
