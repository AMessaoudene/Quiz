package quiz;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login  extends JFrame implements ActionListener{
	JButton play,reset;
	JTextField nameField;
	Login(){
		
		getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		ImageIcon login = new ImageIcon(ClassLoader.getSystemResource("icons/quiz-time-neon-signs-style-text-free-vector.jpg"));
		JLabel image = new JLabel(login);
		add(image);
		
		JLabel header = new JLabel("Quizzy");
		header.setBounds(850, 100, 300, 45);
		header.setFont(new Font("Lato", Font.BOLD,40));
		header.setForeground(Color.white);
		add(header);
		
		JLabel name = new JLabel("Enter your name");
		name.setBounds(845, 200, 300, 45);
		name.setFont(new Font("Lato", Font.BOLD,18));
		name.setForeground(Color.WHITE);
		add(name);
		
		nameField = new JTextField();
		nameField.setBounds(800, 250, 250, 25);
		nameField.setFont(new Font("Lato", Font.BOLD,18));
		add(nameField);
		
		play = new JButton("Play!");
		play.setBounds(750, 300, 120, 25);
		play.setBackground(Color.green);
		play.addActionListener(this);
		add(play);
		
		reset = new JButton("Exit");
		reset.setBounds(1000, 300, 120, 25);
		reset.setBackground(Color.red);
		reset.addActionListener(this);
		add(reset);
		
		image.setBounds(0, 0, 600, 500);
		setSize(1200,500);
		setLocation(200,150);
		setTitle("Quiz Time!");
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == play) {
			String name = nameField.getText();
			setVisible(false);
			new Rules(name);
		}
		else if(ae.getSource() == reset) {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new Login();
	}

}
