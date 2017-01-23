package paczka;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class LaczenieZBaza {

	private Connection connection1;
	
	public void polacz() {

	System.out.println("-------- £¹cznie z baz¹ dnaychh MySQL ------------");

	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Brak sterownika JDBC");
		e.printStackTrace();
		return;
	}

	System.out.println("MySQL JDBC Serownik za³adowany");
	Connection connection = null;

	try {
		connection = DriverManager
		.getConnection("jdbc:mysql://mrmisiek.nazwa.pl:3306/mrmisiek","mrmisiek", "Bazatestowa1");

	} catch (SQLException e) {
		System.out.println("B³¹d po³¹cznia");
		e.printStackTrace();
		return;
	}

	if (connection != null) {
		System.out.println("Po³¹czono z baz¹ danych :)");
	} else {
		System.out.println("B³¹d w ³aczeniu z baz¹ danych!");
		
	
	}
	connection1 = connection;
  }
	
	
	public Connection getConnection() { 
		Connection con = connection1;
		return con;
	}
	
}
  
