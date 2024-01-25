package student.quiz;

public class QuizQuestions {
    private String question;
    private String[] choices;
    private String correctAnswer;
    private String userSelected = "";

    public QuizQuestions(String question, String[] choices, String correctAnswer) {
        this.question = question;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getChoices() {
        return choices;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getUserSelected() {
        return userSelected;
    }

   public void setUserSelectedIndex(String userSelectedIndex) {
    this.userSelected = userSelectedIndex;
}


    public boolean isCorrect() {
        return userSelected == correctAnswer;
    }
}
