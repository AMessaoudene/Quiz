// imports
package quiz;
import javax.swing.*;
import com.formdev.flatlaf.*; // Import FlatLaf
import java.awt.*;
import java.awt.event.*;

public class QuizHard extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
String name;
    
    QuizHard(String name) {
    	this.name = name;
        setTitle("Quizzy : Hard Level");
        try {
            UIManager.setLookAndFeel(new FlatLightLaf()); // Set FlatDarkLaf look-and-feel
            SwingUtilities.updateComponentTreeUI(this); // Update UI to FlatDarkLaf
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
        }
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        
        Image logo = new ImageIcon(getClass().getResource("/icons/Logo.png")).getImage();
        this.setIconImage(logo);

        // Background image setup
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icons/quiz-time-neon-signs-style-text-free-vector.jpg"));
        Image img = backgroundImage.getImage();
        Image newImg = img.getScaledInstance(-1, 400, Image.SCALE_SMOOTH); // Adjusting the height of the image
        backgroundImage = new ImageIcon(newImg);
        JLabel backgroundLabel = new JLabel(backgroundImage);
        add(backgroundLabel, BorderLayout.NORTH); // Setting the image at the top
        
        JPanel questionPanel = new JPanel();
        questionPanel.setBackground(Color.WHITE);
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
        add(questionPanel, BorderLayout.CENTER);

        qno = new JLabel();
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        questionPanel.add(qno);

        question = new JLabel();
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        questionPanel.add(question);
        
        // Questions & Potential correct answers
        questions[0][0] = "The result of 33 X 11 = ";
        questions[0][1] = "333";
        questions[0][2] = "363";//CORRECT
        questions[0][3] = "336";
        questions[0][4] = "366";

        questions[1][0] = "The result of 42 X 24 = ";
        questions[1][1] = "1008";//CORRECT
        questions[1][2] = "924";
        questions[1][3] = "1088";
        questions[1][4] = "942";

        questions[2][0] = "The result of 69 X 96 = ";
        questions[2][1] = "6186";
        questions[2][2] = "6969";
        questions[2][3] = "6536";
        questions[2][4] = "6624";//CORRECT

        questions[3][0] = "The result of 76 X 98 = ";
        questions[3][1] = "7868";
        questions[3][2] = "7448";//CORRECT
        questions[3][3] = "7848";
        questions[3][4] = "7689";

        questions[4][0] = "The result of 528 / 12 = ";
        questions[4][1] = "54";
        questions[4][2] = "36";
        questions[4][3] = "44";//CORRECT
        questions[4][4] = "49";

        questions[5][0] = "The result of 444 / 12 = ";
        questions[5][1] = "41";
        questions[5][2] = "33";
        questions[5][3] = "37";//CORRECT
        questions[5][4] = "42";

        questions[6][0] = "The result of 564 / 47 = ";
        questions[6][1] = "12";//CORRECT
        questions[6][2] = "14";
        questions[6][3] = "22";
        questions[6][4] = "16";

        questions[7][0] = "The result of 736 / 32 = ";
        questions[7][1] = "33";
        questions[7][2] = "28";
        questions[7][3] = "29";
        questions[7][4] = "23";//CORRECT
        
        questions[8][0] = "In R, solve this equation : x^2+2x+1=0";
        questions[8][1] = "1";
        questions[8][2] = "-1";//CORRECT
        questions[8][3] = "0";
        questions[8][4] = "i";

        questions[9][0] = "In Z, solve this equation : x^2 + 1 = 0";
        questions[9][1] = "i";
        questions[9][2] = "-i";
        questions[9][3] = "-1";
        questions[9][4] = "i,-i";//CORRECT
        
        // Correct answers
        answers[0][1] = "363";
        answers[1][1] = "1008";
        answers[2][1] = "6624";
        answers[3][1] = "7448";
        answers[4][1] = "44";
        answers[5][1] = "37";
        answers[6][1] = "12";
        answers[7][1] = "23";
        answers[8][1] = "-1";
        answers[9][1] = "i,-i";
        
        // Radio buttons and options
        JPanel optionsPanel = new JPanel(new GridBagLayout());
        optionsPanel.setBackground(Color.WHITE);
        add(optionsPanel, BorderLayout.SOUTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 20, 10); // Padding between components

        opt1 = new JRadioButton();
        customizeRadioButton(opt1);
        optionsPanel.add(opt1, gbc);

        gbc.gridx = 1;
        opt2 = new JRadioButton();
        customizeRadioButton(opt2);
        optionsPanel.add(opt2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        opt3 = new JRadioButton();
        customizeRadioButton(opt3);
        optionsPanel.add(opt3, gbc);

        gbc.gridx = 1;
        opt4 = new JRadioButton();
        customizeRadioButton(opt4);
        optionsPanel.add(opt4, gbc);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        // Buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.WHITE);
        add(buttonsPanel, BorderLayout.EAST);

        next = new JButton("Next");
        customizeButton(next);
        next.addActionListener(this);
        buttonsPanel.add(next);

        submit = new JButton("Submit");
        customizeButton(submit);
        submit.addActionListener(this);
        submit.setEnabled(false);
        buttonsPanel.add(submit);
        
        // Score
        start(count);
        
        try {
            UIManager.setLookAndFeel(new FlatLightLaf()); // Set FlatLaf look-and-feel
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    private void customizeButton(JButton button) {
        button.setFont(new Font("Tahoma", Font.PLAIN, 22));
        button.setBackground(new Color(65, 105, 225));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Padding around the text
    }

    private void customizeRadioButton(JRadioButton radioButton) {
        radioButton.setBackground(Color.WHITE);
        radioButton.setFont(new Font("Dialog", Font.PLAIN, 20));
        radioButton.setFocusPainted(false);
        radioButton.setBorder(BorderFactory.createLineBorder(new Color(65, 105, 225), 2)); // Custom border
        radioButton.setPreferredSize(new Dimension(300, 40)); // Set preferred size for the radio buttons
        radioButton.setMargin(new Insets(10, 10, 10, 10)); // Add padding around the text
    }
 
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        }
         else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    //timer
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if (timer > 0) { 
            g.drawString(time, 1000, 500);
        } else {
            g.drawString("Times up!!", 1000, 500);
        }
        
        timer--;
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
    	qno.setText("" + (count + 1) + ". " + questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new QuizHard("User");
    }
}
