package paczka;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SprawdzenieDanychLogowania {

	private static Connection dbConnection1;

	public  SprawdzenieDanychLogowania(Connection dbConnection){
		dbConnection1 = dbConnection;
		
	}
	public boolean sprawdz(String login, String password) throws SQLException {
		
		Connection dbConnection;
		dbConnection = dbConnection1;
		Statement statement = null;
		boolean succes = false;

		String selectTableSQL = "SELECT LOGIN, PASSWORD FROM OSOBA";

		try {
			dbConnection = dbConnection1;
			statement = dbConnection.createStatement();

			System.out.println(selectTableSQL);

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);

			while (rs.next()) {

				String login1 = rs.getString("LOGIN");
				System.out.println("Login:"+ login1);
				if(login1.equals(login)){
					String password1 = rs.getString("PASSWORD");
					if(password1.equals(password)){
						succes = true;
						break;
					}	
				}
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

		}
		return succes;
	}
}
