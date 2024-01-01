// imports
package quiz;
import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JButton play, reset;
    JTextField nameField;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Image logo = new ImageIcon(getClass().getResource("/icons/Logo.png")).getImage();
        this.setIconImage(logo);

        ImageIcon login = new ImageIcon(ClassLoader.getSystemResource("icons/Logo.png"));
        JLabel image = new JLabel(login);
        add(image);

        JLabel header = new JLabel("Welcome to Quizzy!");
        header.setBounds(770, 100, 300, 45);
        header.setFont(new Font("Lato", Font.BOLD, 30));
        header.setForeground(Color.black);
        add(header);

        JLabel nameLabel = new JLabel("Enter your name");
        nameLabel.setBounds(845, 200, 300, 45);
        nameLabel.setFont(new Font("Lato", Font.BOLD, 18));
        nameLabel.setForeground(Color.BLACK);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(800, 250, 250, 25);
        nameField.setFont(new Font("Lato", Font.BOLD, 18));
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

        getRootPane().setDefaultButton(play); // Direct Enter key to 'play' button
        InputMap inputMap = play.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "clickButton");

        ActionMap actionMap = play.getActionMap();
        actionMap.put("clickButton", new AbstractAction() {
            public void actionPerformed(ActionEvent ae) {
                play.doClick(); // Trigger 'play' button action
            }
        });

        image.setBounds(0, -30, 600, 500);
        setSize(1200, 500);
        setLocationRelativeTo(null);
        setTitle("Quiz Time!");

        // Adding the ComponentListener to center the frame when it's resized
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                centerFrame(); // Call method to center the frame on resize
            }
        });

        setVisible(true);
    }

    // Method to center the frame
    private void centerFrame() {
        Dimension windowSize = getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - windowSize.width) / 2;
        int y = (screenSize.height - windowSize.height) / 2;
        setLocation(x, y);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == play) {
            String playerName = nameField.getText();
            setVisible(false);
            new Rules(playerName);
        } else if (ae.getSource() == reset) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
