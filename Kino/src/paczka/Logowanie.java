package paczka;
import javax.swing.*;
import java.sql.Connection;

public class Logowanie  extends JFrame {

	private static final long serialVersionUID = 2L;
		
	public Logowanie(Connection con) {
		super("Test akcji");

		JPanel buttonPanel = new ButtonPanel(con);
		add(buttonPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}