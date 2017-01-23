package paczka;
import java.awt.EventQueue;
import java.sql.Connection;

public class Main {

	
	public static void main(String[] argv) {
		LaczenieZBaza poloczeneie = new LaczenieZBaza();
		poloczeneie.polacz();
		Connection con = poloczeneie.getConnection();

		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Okno(con);
			}
		});
		
		
		
		
		
		
		
		
	}
	
}
