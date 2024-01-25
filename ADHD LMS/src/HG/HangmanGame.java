package HG;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;


public class HangmanGame extends JFrame {

    private static final String[] CATEGORIES = {"Animals", "Countries", "Programming Languages"};
    private static final String[][] WORDS = {
            {"LION", "ELEPHANT", "GIRAFFE", "MONKEY", "KANGAROO"},
            {"CANADA", "BRAZIL", "JAPAN", "AUSTRALIA", "GERMANY"},
            {"JAVA", "PYTHON", "C++", "JAVASCRIPT", "SWIFT"}
    };

    private String currentCategory;
    private String currentWord;
    private char[] guessedWord;
    private int incorrectAttempts;

    private JLabel categoryLabel;
    private JLabel wordLabel;
    private JLabel attemptsLabel;
    private JTextField inputField;
    private JButton guessButton;
    private JButton newGameButton;
    private Connection connection;
    private Timer timer;
    private int totalPlaytimeToday;


    public HangmanGame() {
        setTitle("Hangman Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeGame();
        initializeGUI();

 initializePlaytimeTimer();

        setLayout(new GridLayout(5, 1));
        setVisible(true);
    }
private void initializeDatabase() {
        try {
            // Replace "jdbc:sqlite:hangman_scores.db" with your database URL
            connection = DriverManager.getConnection("jdbc:sqlite:hangman_scores.db");

            // Create the scores table if it does not exist
             String createPlaytimeTableQuery = "CREATE TABLE IF NOT EXISTS playtime (id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, playtime INT)";
            connection.createStatement().executeUpdate(createPlaytimeTableQuery);

            // Initialize total playtime for today
            totalPlaytimeToday = getTodayPlaytime();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error initializing database.");
            System.exit(1);
        }
}
private void initializePlaytimeTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Increment playtime every minute
                totalPlaytimeToday += 1;
                System.out.println("Total playtime today: " + totalPlaytimeToday + " minutes");

                if (totalPlaytimeToday > 120) {
                    JOptionPane.showMessageDialog(HangmanGame.this, "You have reached the maximum playtime for today (2 hours).");
                    System.exit(0); // Exit the application after reaching the limit
                }
            }
        }, 0, 60000); // Run every minute
    }

    private int getTodayPlaytime() {
        try {
            String currentDate = new java.sql.Date(System.currentTimeMillis()).toString();
            String selectQuery = "SELECT SUM(playtime) FROM playtime WHERE date = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, currentDate);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void savePlaytime(int playtime) {
        try {
            String currentDate = new java.sql.Date(System.currentTimeMillis()).toString();
            String insertQuery = "INSERT INTO playtime (date, playtime) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, currentDate);
                preparedStatement.setInt(2, playtime);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving playtime to the database.");
        }
    }

    private void saveScore(String playerName, int score) {
        try {
            String insertQuery = "INSERT INTO scores (player_name, score) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, playerName);
                preparedStatement.setInt(2, score);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving score to the database.");
        }
    }
    private void initializeGame() {
        Random random = new Random();
        int categoryIndex = random.nextInt(CATEGORIES.length);
        currentCategory = CATEGORIES[categoryIndex];

        int wordIndex = random.nextInt(WORDS[categoryIndex].length);
        currentWord = WORDS[categoryIndex][wordIndex].toUpperCase();
        guessedWord = new char[currentWord.length()];
        Arrays.fill(guessedWord, '_');
        incorrectAttempts = 0;
    }

    private void initializeGUI() {
        categoryLabel = new JLabel("Category: " + currentCategory);
        add(categoryLabel);

        wordLabel = new JLabel("Word: " + String.valueOf(guessedWord));
        add(wordLabel);

        attemptsLabel = new JLabel("Attempts left: " + (6 - incorrectAttempts));
        add(attemptsLabel);

        inputField = new JTextField();
        add(inputField);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess();
            }
        });
        add(guessButton);

        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });
        add(newGameButton);
    }

    private void handleGuess() {
        String input = inputField.getText().toUpperCase();
        if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
            char guess = input.charAt(0);
            if (currentWord.indexOf(guess) != -1) {
                updateGuessedWord(guess);
            } else {
                incorrectAttempts++;
            }

            inputField.setText("");
            updateUI();
            checkGameStatus();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid single letter.");
        }
    }

    private void updateGuessedWord(char guess) {
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) == guess) {
                guessedWord[i] = guess;
            }
        }
    }

    private void updateUI() {
        wordLabel.setText("Word: " + String.valueOf(guessedWord));
        attemptsLabel.setText("Attempts left: " + (6 - incorrectAttempts));
    }

    private void checkGameStatus() {
        if (incorrectAttempts >= 6) {
            endGame("Sorry, you ran out of attempts. The word was: " + currentWord);
        } else if (Arrays.equals(guessedWord, currentWord.toCharArray())) {
            endGame("Congratulations! You guessed the word: " + currentWord);
        }
    }

    private void endGame(String message) {
        JOptionPane.showMessageDialog(this, message);

        String playerName = JOptionPane.showInputDialog("Enter your name:");
        if (playerName != null && !playerName.isEmpty()) {
            saveScore(playerName, 6 - incorrectAttempts);
            savePlaytime(totalPlaytimeToday);
        }

        timer.cancel(); // Stop the timer
        newGame();
    }

    private void newGame() {
        initializeGame();
        updateUI();
        categoryLabel.setText("Category: " + currentCategory);
    }

}
