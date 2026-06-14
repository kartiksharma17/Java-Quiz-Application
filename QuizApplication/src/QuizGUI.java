import javax.swing.*;
import java.awt.*;

public class QuizGUI extends JFrame {

    private Question[] questions;

    private int currentQuestion = 0;
    private int score = 0;

    private JLabel questionLabel;

    private JRadioButton optionA;
    private JRadioButton optionB;
    private JRadioButton optionC;
    private JRadioButton optionD;

    private ButtonGroup group;

    private JButton nextButton;

    public QuizGUI() {

        questions = QuizApplication.createQuestions();

        setTitle("Java Quiz Application");
        setSize(720, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with nice padding
        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        mainPanel.setBackground(new Color(240, 248, 255)); // Light blue background

        // Question Panel with colored header
        JPanel questionPanel = new JPanel(new BorderLayout());
        questionPanel.setBackground(new Color(255, 255, 255));
        questionPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(100, 150, 220), 3),
                BorderFactory.createEmptyBorder(20, 25, 20, 25)
        ));

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 23));
        questionLabel.setForeground(new Color(25, 40, 90));
        questionLabel.setHorizontalAlignment(JLabel.CENTER);

        questionPanel.add(questionLabel, BorderLayout.CENTER);
        mainPanel.add(questionPanel, BorderLayout.NORTH);

        // Options Panel
        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new GridLayout(4, 1, 0, 15));
        optionPanel.setBackground(new Color(240, 248, 255));
        optionPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        optionA = createStyledRadioButton(new Color(70, 130, 180));
        optionB = createStyledRadioButton(new Color(70, 130, 180));
        optionC = createStyledRadioButton(new Color(70, 130, 180));
        optionD = createStyledRadioButton(new Color(70, 130, 180));

        group = new ButtonGroup();
        group.add(optionA);
        group.add(optionB);
        group.add(optionC);
        group.add(optionD);

        optionPanel.add(optionA);
        optionPanel.add(optionB);
        optionPanel.add(optionC);
        optionPanel.add(optionD);

        mainPanel.add(optionPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 248, 255));

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 18));
        nextButton.setBackground(new Color(0, 123, 255));     // Bright blue
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.setPreferredSize(new Dimension(200, 55));
        nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nextButton.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

        buttonPanel.add(nextButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        nextButton.addActionListener(e -> checkAnswer());

        loadQuestion();

        setVisible(true);
    }

    // Styled radio button with color
    private JRadioButton createStyledRadioButton(Color accentColor) {
        JRadioButton rb = new JRadioButton();
        rb.setFont(new Font("Arial", Font.PLAIN, 18));
        rb.setBackground(new Color(255, 255, 255));
        rb.setForeground(new Color(40, 50, 80));
        rb.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 220, 240), 2),
                BorderFactory.createEmptyBorder(12, 15, 12, 15)
        ));
        return rb;
    }

    private void loadQuestion() {

        Question q = questions[currentQuestion];

        questionLabel.setText("<html>" + q.getQuestionText() + "</html>");

        optionA.setText("A. " + q.getOption1());
        optionB.setText("B. " + q.getOption2());
        optionC.setText("C. " + q.getOption3());
        optionD.setText("D. " + q.getOption4());

        group.clearSelection();
    }

    private void checkAnswer() {

        char selectedAnswer = ' ';

        if (optionA.isSelected()) selectedAnswer = 'A';
        else if (optionB.isSelected()) selectedAnswer = 'B';
        else if (optionC.isSelected()) selectedAnswer = 'C';
        else if (optionD.isSelected()) selectedAnswer = 'D';

        if (selectedAnswer == questions[currentQuestion].getCorrectAnswer()) {
            score++;
        }

        currentQuestion++;

        if (currentQuestion < questions.length) {
            loadQuestion();
        }
        else {
            showResult();
        }
    }

    private void showResult() {

        double percentage = (score * 100.0) / questions.length;

        String message = "🎉 Quiz Completed!\n\n" +
                "Your Score: " + score + " / " + questions.length + "\n" +
                "Percentage: " + String.format("%.1f", percentage) + "%";

        JOptionPane.showMessageDialog(
                this,
                message,
                "Quiz Result",
                JOptionPane.INFORMATION_MESSAGE
        );

        System.exit(0);
    }
}