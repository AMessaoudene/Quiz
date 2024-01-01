// imports
package quiz;
import com.formdev.flatlaf.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Rules extends JFrame implements ActionListener {
    String Name;
    JButton back, start;

    Rules(String name) {
        this.Name = name;
        try {
            UIManager.setLookAndFeel(new FlatLightLaf()); // Applying FlatLaf theme
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
        }

        getContentPane().setBackground(new Color(45, 45, 45)); // Dark background

        Image logo = new ImageIcon(getClass().getResource("/icons/Logo.png")).getImage();
        this.setIconImage(logo);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(45, 45, 45)); // Dark background

        JLabel header = new JLabel("Welcome " + name + " !");
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 40));
        header.setForeground(Color.white);
        mainPanel.add(header, BorderLayout.NORTH); // Add the header label to the main panel

        JTextArea rules = new JTextArea();
        rules.setFont(new Font("Arial", Font.PLAIN, 18));
        rules.setEditable(false);
        rules.setLineWrap(true);
        rules.setWrapStyleWord(true);
        rules.setBackground(new Color(64, 64, 64)); // Dark gray background for text area
        rules.setForeground(Color.white);
        rules.setText(
                "Rules to follow:\n\n" +
                        "1. No cheating allowed.\n\n" +
                        "2. The level of questions is increased by steps.\n\n" +
                        "3. Think carefully before you answer.\n\n" +
                        "4. Good Luck!\n\n"
        );
        mainPanel.add(rules, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(45, 45, 45)); // Dark background

        start = createButton("Start", Color.decode("#27ae60"));
        back = createButton("Back", Color.decode("#c0392b"));

        buttonPanel.add(start);
        buttonPanel.add(back);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        getRootPane().getActionMap().put("Enter", new AbstractAction() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new Choice(Name); // Open the choice screen with the entered name
            }
        });

        setSize(500, 400);
        setLocationRelativeTo(null);
        setTitle("Quiz Time!");
        setVisible(true);
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.white);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Choice(Name);
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
