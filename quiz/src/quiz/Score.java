// imports
package quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Class representing the score window
public class Score extends JFrame {

    // Constructor to create the score window
    Score(String name, int score) {
        setTitle("Quizzy : Score"); // Set window title
        setBounds(400, 150, 600, 400); // Set window bounds
        getContentPane().setBackground(Color.WHITE); // Set background color
        setLayout(new BorderLayout()); // Use BorderLayout for components
        
        Image logo = new ImageIcon(getClass().getResource("/icons/Logo.png")).getImage();
        this.setIconImage(logo);

        // Panel to organize components vertically
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Label to thank the player
        JLabel heading = new JLabel("Thank you " + name + " for playing Quizzy!");
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        heading.setFont(new Font("Arial", Font.BOLD, 28));
        centerPanel.add(Box.createVerticalStrut(50)); // Add vertical spacing
        centerPanel.add(heading);

        // Label to display the player's score
        JLabel scoreLabel = new JLabel("Your score is " + score + "% !");
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        centerPanel.add(Box.createVerticalStrut(30)); // Add vertical spacing
        centerPanel.add(scoreLabel);

        // Button to play again
        JButton playAgainButton = new JButton("Play Again");
        customizeButton(playAgainButton); // Method to customize button appearance

        // ActionListener for the play again button
        playAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Hide the score window
                new Login(); // Start a new quiz
            }
        });

        playAgainButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playAgainButton.setPreferredSize(new Dimension(200, 50));
        centerPanel.add(Box.createVerticalStrut(60)); // Add vertical spacing
        centerPanel.add(playAgainButton);
        
        // Set up Key Binding for the Enter key
        KeyStroke enterKey = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        playAgainButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(enterKey, "playAgain");
        playAgainButton.getActionMap().put("playAgain", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                // Action to perform when Enter key is pressed
                setVisible(false); // Hide the score window
                new Login(); // Start a new quiz
            }
        });

        add(centerPanel, BorderLayout.CENTER); // Add the center panel to the window

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        setLocationRelativeTo(null); // Center the window
        setVisible(true); // Make the window visible
    }

    // Method to customize button appearance
    private void customizeButton(JButton button) {
        button.setBackground(new Color(65, 105, 225)); // Set button background color
        button.setForeground(Color.WHITE); // Set text color
        button.setFocusPainted(false); // Remove focus border
        button.setFont(new Font("Arial", Font.BOLD, 20)); // Set font
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Set padding
    }    

    // Main method to start the application with default user and score
    public static void main(String[] args) {
        new Score("User", 0); // Create an instance of Score with default user and score
    }
}
