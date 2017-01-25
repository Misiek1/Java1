package paczka;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
//import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.sql.Connection;
import java.sql.SQLException;
//import java.util.concurrent.TimeUnit;


public class ButtonPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton zalogujsieButton;
	private Connection connection; 
	private JTextField nameField; //pole na nazwê
    private JPasswordField passField; //pole na has³o
    private JButton loginButton; //przycisk logowania
    private JButton anulujButton;

	public static final int HEIGHT = 300;
	public static final int WIDTH = 600;
	JPanel welcomePanel = new JPanel();
	JPanel parentPanel = new JPanel();
	JLabel textF = new JLabel();
	JLabel text1 = new JLabel();
	
	 public ButtonPanel(Connection connection1) {
		connection = connection1;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		welcomePanel.setLayout(new GridLayout(5, 1));
		
		zalogujsieButton = new JButton("Zaloguj siê");
		
		text1.setText("Witaj w kinie NaJAVIE");
		welcomePanel.add(text1);
		welcomePanel.add(zalogujsieButton);
		anulujButton = new JButton("Anuluj");
		welcomePanel.add(anulujButton);
		anulujButton.addActionListener(this);
		zalogujsieButton.addActionListener(this);
		add(welcomePanel);
		

		
	
	}

	@Override
	public void actionPerformed(ActionEvent e1) {
		Object source = e1.getSource();

		if(source == anulujButton){
			System.exit(0);
		}
		else if(source == loginButton){
			String login = nameField.getText();
			String password1 = new String(passField.getPassword());
			System.out.println("login "+login);
			SprawdzenieDanychLogowania nowe = new SprawdzenieDanychLogowania(connection);
			try {
				boolean wynik1 = nowe.sprawdz(login, password1);
				if (wynik1 == true){				
					textF.setText(" Witaj ");
					parentPanel.removeAll();
				}
				else{
					textF.setText(" B³¹d logowania :( ");	
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		else if(source == zalogujsieButton){
			//textF.setText(" Witaj ");
			zalogujsieButton.removeActionListener(this);
			welcomePanel.removeAll();
			welcomePanel.setLayout(new GridLayout(1, 1));
			System.out.println("dziala ");
			
			JPanel inputPanel = new JPanel();
			JPanel loginAnulujButtons = new JPanel();
			
			JLabel name = new JLabel("Name: ");
	        JLabel password = new JLabel("Password: ");
		    nameField = new JTextField();
		    passField = new JPasswordField();

	        inputPanel.setLayout(new GridLayout(2, 2));
	        inputPanel.add(name);
	        inputPanel.add(nameField);
	        inputPanel.add(password);
	        inputPanel.add(passField);
	        
	        //tworzymy przycisk logowania i anulowania
	        loginAnulujButtons.setLayout(new GridLayout(1, 2));
	        loginButton = new JButton("Zaloguj");
	        anulujButton = new JButton("Anuluj");
	        loginAnulujButtons.add(loginButton);
	        loginAnulujButtons.add(anulujButton);
	        
	        //tworzymy ostaeczne wygl¹d okna z trzech paneli
	        parentPanel.setLayout(new BorderLayout());
	        parentPanel.add(inputPanel, BorderLayout.CENTER);
	        parentPanel.add(loginAnulujButtons, BorderLayout.SOUTH);
	        parentPanel.add(textF, BorderLayout.NORTH);
	        loginButton.addActionListener(this);
	        anulujButton.addActionListener(this);
	        welcomePanel.add(parentPanel);
	        validate();
	        System.out.println("dziala ");
	
		}

	}
}