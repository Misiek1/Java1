package paczka;
import javax.swing.*;
import java.sql.Connection;

public class Okno  extends JFrame {

	private static final long serialVersionUID = 2L;
		
	public Okno(Connection con) {
		super("Rezerwacja filmu");

		JPanel cinemaPanel = new ButtonPanel(con);
		add(cinemaPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}