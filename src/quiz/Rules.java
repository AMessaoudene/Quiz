package quiz;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{
	
	String Name;
	JButton back,start;
	Rules(String name){
		this.Name = name;
		getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel header = new JLabel("Welcome " + name + " !");
		header.setBounds(230, 20, 400, 80);
		header.setFont(new Font("Lato", Font.BOLD,40));
		header.setForeground(Color.white);
		add(header);
		
		JLabel rules = new JLabel();
        rules.setBounds(20, 110, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setForeground(Color.white);
        rules.setText(
            "<html>"+ 
                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
            "<html>"
        );
        add(rules);
        
        start = new JButton("Start");
        start.setBounds(250, 500, 100, 30);
        start.setBackground(Color.green);
        start.addActionListener(this);
        add(start);
        
        back = new JButton("Back");
        back.setBounds(400, 500, 100, 30);
        back.setBackground(Color.red);
        back.addActionListener(this);
        add(back);
		
		setSize(800,650);
		setLocation(350,100);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }

	public static void main(String[] args) {
		new Rules("User");
	}

}
