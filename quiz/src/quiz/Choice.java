// imports
package quiz;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Choice extends JFrame implements ActionListener {

    String Name;
    JButton easy, hard;

    Choice(String name) {
        this.Name = name; // Set the user's name
        getContentPane().setBackground(Color.WHITE); // Set background color
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
        
        Image logo = new ImageIcon(getClass().getResource("/icons/Logo.png")).getImage();
        this.setIconImage(logo);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding between components

        JLabel header = new JLabel("Choose your level, " + name);
        header.setFont(new Font("Arial", Font.BOLD, 40));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(header, gbc); // Add the header label to the frame

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 20)); // 1 row, 2 columns
        buttonPanel.setBackground(Color.WHITE); // Set background color

        easy = createButton("Easy", Color.GREEN); // Create Easy button
        hard = createButton("Hard", Color.RED); // Create Hard button

        buttonPanel.add(easy); // Add Easy button to the button panel
        buttonPanel.add(hard); // Add Hard button to the button panel

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc); // Add the button panel to the frame

        setSize(800, 400); // Set window size
        setLocationRelativeTo(null); // Center the window
        setTitle("Quiz Time!"); // Set window title
        setVisible(true); // Make the window visible
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
