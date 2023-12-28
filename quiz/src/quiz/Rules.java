package quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
    String Name;
    JButton back, start;

    Rules(String name) {
        this.Name = name;
        getContentPane().setBackground(Color.decode("#2c3e50"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.decode("#2c3e50"));

        JLabel header = new JLabel("Welcome " + name + " !");
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 40));
        header.setForeground(Color.white);
        mainPanel.add(header, BorderLayout.NORTH);

        JTextArea rules = new JTextArea();
        rules.setFont(new Font("Arial", Font.PLAIN, 18));
        rules.setEditable(false);
        rules.setLineWrap(true);
        rules.setWrapStyleWord(true);
        rules.setText(
                "Rules to follow:\n\n" +
                        "1. No cheating allowed.\n\n" +
                        "2. The level of questions is increased by steps.\n\n" +
                        "3. Think carefully before you answer.\n\n" +
                        "4. Good Luck!\n\n"
        );
        mainPanel.add(rules, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.decode("#2c3e50"));

        start = createButton("Start", Color.decode("#27ae60"));
        back = createButton("Back", Color.decode("#c0392b"));

        buttonPanel.add(start);
        buttonPanel.add(back);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setSize(800, 650);
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
