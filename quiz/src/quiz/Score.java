package quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame {

    Score(String name, int score) {
    	setTitle("Quizzy : Score");
        setBounds(400, 150, 600, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel heading = new JLabel("Thank you " + name + " for playing Quizzy!");
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        centerPanel.add(Box.createVerticalStrut(100));
        centerPanel.add(heading);

        JLabel scoreLabel = new JLabel("Your score is " + score + "% !");
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
        centerPanel.add(Box.createVerticalStrut(50));
        centerPanel.add(scoreLabel);

        JButton playAgainButton = new JButton("Play Again");
        customizeButton(playAgainButton);

        // Add ActionListener for the button
        playAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

        playAgainButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playAgainButton.setPreferredSize(new Dimension(200, 40));
        centerPanel.add(Box.createVerticalStrut(80));
        centerPanel.add(playAgainButton);

        add(centerPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void customizeButton(JButton button) {
        button.setBackground(new Color(30, 144, 255));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
