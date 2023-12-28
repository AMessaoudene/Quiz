package quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizEasy extends JFrame {
    private JLabel questionLabel;
    private JButton buttonA, buttonB, buttonC, buttonD;
    private JButton prevButton, nextButton;
    private int currentQuestion = 0;
    private int score = 0;
    String Name;

    // Questions and answers
    private String[] questions = {
            "What is the result of 0 + 0 ?",
            "What is the result of 0 + 4 ?",
            "What is the result of 2 + 1 ?",
            "What is the result of 2 - 1 ?",
            "What is the result of 6 + 4 ?",
            "What is the result of 10 * 2 ?",
            "What is the result of 7 - 1 ?",
            "What is the result of 3 + 4 ?",
            "What is the result of 2 * 2 ?",
            "What is the result of 9 * 9 ?",
    };

    private String[][] options = {
            {"0", "5", "9", "1"},
            {"0", "4", "3", "5"},
            {"3", "5", "6", "7"},
            {"3", "5", "1", "4"},
            {"10", "6", "3", "7"},
            {"3", "4", "20", "8"},
            {"3", "5", "6", "4"},
            {"7", "1", "6", "0"},
            {"4", "1", "6", "0"},
            {"15", "61", "77", "81"},
    };

    private int[] correctAnswers = {0, 1, 1, 2, 0, 2, 2, 0, 0, 3}; // Index of the correct answer for each question

    private int selectedOption = -1; // Variable to track the selected option

    public QuizEasy(String Name) {
        this.Name = Name;
        setTitle("Quizzy : Easy Level");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        setupUI();
        displayQuestion();

        setVisible(true);
    }

    private void setupUI() {
        JPanel questionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Larger font size for questions
        questionPanel.add(questionLabel);
        add(questionPanel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // Padding for options

        buttonA = createStyledButton();
        buttonB = createStyledButton();
        buttonC = createStyledButton();
        buttonD = createStyledButton();

        buttonA.addActionListener(new OptionButtonListener(0));
        buttonB.addActionListener(new OptionButtonListener(1));
        buttonC.addActionListener(new OptionButtonListener(2));
        buttonD.addActionListener(new OptionButtonListener(3));

        optionsPanel.add(buttonA);
        optionsPanel.add(buttonB);
        optionsPanel.add(buttonC);
        optionsPanel.add(buttonD);

        add(optionsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Spacing for buttons

        prevButton = createStyledButton("Previous");
        nextButton = createStyledButton("Next");

        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentQuestion > 0) {
                    currentQuestion--;
                    displayQuestion();
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                currentQuestion++;
                if (currentQuestion < questions.length) {
                    displayQuestion();
                } else {
                    showResult();
                }
            }
        });

        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JButton createStyledButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(200, 60)); // Button size for options
        button.setFont(new Font("Arial", Font.PLAIN, 18)); // Font size for options
        return button;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(120, 40)); // Button size for navigation buttons
        button.setFont(new Font("Arial", Font.BOLD, 16)); // Font size for navigation buttons
        button.setBackground(Color.BLUE); // Background color for navigation buttons
        button.setForeground(Color.WHITE); // Text color for navigation buttons
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Border for navigation buttons
        return button;
    }

    private void checkAnswer() {
        if (selectedOption != -1 && selectedOption == correctAnswers[currentQuestion]) {
            score++;
        }
    }

    private void displayQuestion() {
        questionLabel.setText(questions[currentQuestion]);
        buttonA.setText("A. " + options[currentQuestion][0]);
        buttonB.setText("B. " + options[currentQuestion][1]);
        buttonC.setText("C. " + options[currentQuestion][2]);
        buttonD.setText("D. " + options[currentQuestion][3]);

        // Enable buttons for the new question
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);

        selectedOption = -1; // Reset selected option for the new question
    }

    private void handleOptionSelection(int selectedIndex) {
        selectedOption = selectedIndex;

        // Disable buttons after an option is selected
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "Quiz completed!\nYour score: " + score + " out of 10",
                "Quiz Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private class OptionButtonListener implements ActionListener {
        private final int index;

        public OptionButtonListener(int index) {
            this.index = index;
        }

        public void actionPerformed(ActionEvent e) {
            handleOptionSelection(index);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QuizEasy("User");
            }
        });
    }
}
