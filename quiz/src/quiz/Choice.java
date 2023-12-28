package quiz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Choice extends JFrame implements ActionListener {

    String Name;
    JButton easy, hard;

    Choice(String name) {
        this.Name = name;
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel header = new JLabel("Choose your level, " + name);
        header.setFont(new Font("Arial", Font.BOLD, 40));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 70, 20));
        buttonPanel.setBackground(Color.WHITE);

        easy = createButton("Easy", Color.GREEN);
        hard = createButton("Hard", Color.RED);

        buttonPanel.add(easy);
        buttonPanel.add(hard);

        add(buttonPanel, BorderLayout.CENTER);

        setSize(800, 400);
        setLocationRelativeTo(null);
        setTitle("Quiz Time!");
        setVisible(true);
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(120, 40));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == easy) {
            setVisible(false);
            new QuizEasy(Name);
        } else if (ae.getSource() == hard) {
            setVisible(false);
            new QuizHard(Name);
        }
    }

    public static void main(String[] args) {
        new Choice("User");
    }
}
