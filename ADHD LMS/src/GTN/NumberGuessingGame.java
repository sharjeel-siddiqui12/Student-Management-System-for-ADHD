import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class NumberGuessingGame extends JFrame {

    private int targetNumber;
    private int attempts;
    private int initialScore;
    private int totalPlaytimeToday;
    private JTextField guessField;
    private JLabel resultLabel;
    private JLabel attemptsLabel;
    private JLabel scoreLabel;
    private Connection connection;
    private String currentPlayer;
    private LocalTime sessionStartTime;

    public NumberGuessingGame() {
        
        initializeUI();
        startNewGame();
    }

    private void initializeDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "your_username", "your_password");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void initializeUI() {
        setTitle("Number Guessing Game");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JLabel instructionLabel = new JLabel("Guess the number between 1 and 100:");
        guessField = new JTextField();
        JButton guessButton = new JButton("Guess");
        resultLabel = new JLabel("");
        attemptsLabel = new JLabel("");
        scoreLabel = new JLabel("");

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        panel.add(instructionLabel);
        panel.add(guessField);
        panel.add(guessButton);
        panel.add(resultLabel);
        panel.add(attemptsLabel);
        panel.add(scoreLabel);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startNewGame() {
        targetNumber = (int) (Math.random() * 100) + 1;
        attempts = 0;
        initialScore = 100;
        updateAttemptsLabel();
        updateScoreLabel();
        resultLabel.setText("");
        guessField.setText("");

        currentPlayer = JOptionPane.showInputDialog("Enter your username:");
        sessionStartTime = LocalTime.now();
        totalPlaytimeToday = calculateTotalPlaytimeToday();
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(guessField.getText());
            attempts++;

            if (guess == targetNumber) {
                resultLabel.setText("Congratulations! You guessed the correct number.");
                saveScoreToDatabase(initialScore);
                startNewGame();
            } else if (guess < targetNumber) {
                resultLabel.setText("Try higher!");
            } else {
                resultLabel.setText("Try lower!");
            }

            updateAttemptsLabel();
            updateScoreLabel();

            if (attempts == 10) {
                resultLabel.setText("Game over. The correct number was " + targetNumber);
                startNewGame();
            }

            if (isTimeLimitExceeded()) {
                resultLabel.setText("Time limit exceeded. You cannot play for more than 2 hours a day.");
                startNewGame();
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a number.");
        }
    }

    private void updateAttemptsLabel() {
        attemptsLabel.setText("Attempts: " + attempts);
    }

    private void updateScoreLabel() {
        scoreLabel.setText("Score: " + initialScore);
        initialScore -= 10; // Decrease score with each attempt
    }

    private void saveScoreToDatabase(int score) {
        try {
            String query = "INSERT INTO scores (player, score) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, currentPlayer);
            preparedStatement.setInt(2, score);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int calculateTotalPlaytimeToday() {
        try {
            LocalDate currentDate = LocalDate.now();
            String query = "SELECT SUM(playtime) FROM playtime WHERE player = ? AND date = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, currentPlayer);
            preparedStatement.setString(2, currentDate.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void updateTotalPlaytime() {
        try {
            LocalDate currentDate = LocalDate.now();
            String query = "INSERT INTO playtime (player, date, playtime) VALUES (?, ?, ?)" +
                    "ON DUPLICATE KEY UPDATE playtime = playtime + ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, currentPlayer);
            preparedStatement.setString(2, currentDate.toString());
            preparedStatement.setInt(3, totalPlaytimeToday);
            preparedStatement.setInt(4, totalPlaytimeToday);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isTimeLimitExceeded() {
        LocalTime currentTime = LocalTime.now();
        long playtimeSeconds = sessionStartTime.until(currentTime, java.time.temporal.ChronoUnit.SECONDS);
        int playtimeToday = totalPlaytimeToday + (int) playtimeSeconds;
        if (playtimeToday > 20) { // 7200 seconds = 2 hours
            updateTotalPlaytime();
            return true;
        }
        totalPlaytimeToday = playtimeToday;
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGuessingGame();
            }
        });
    }
}
