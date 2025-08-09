import java.sql.*;
import java.util.*;

public class QuizService {

    public static void takeQuiz(int quizId, int userId) throws Exception {
        ResultSet questions = QuestionDAO.getQuestionsForQuiz(quizId);
        int score = 0;
        int total = 0;

        Scanner scanner = new Scanner(System.in);

        // Create quiz attempt
        int attemptId = AttemptDAO.createQuizAttempt(userId, quizId);

        while (questions.next()) {
            int questionId = questions.getInt("id");
            String questionText = questions.getString("question_text");
            System.out.println("Q: " + questionText);

            ResultSet options = QuestionDAO.getOptionsForQuestion(questionId);
            Map<Integer, Boolean> optionMap = new HashMap<>();
            Map<Integer, String> displayMap = new HashMap<>();
            int i = 1;

            while (options.next()) {
                int optionId = options.getInt("id");
                String text = options.getString("option_text");
                boolean isCorrect = options.getBoolean("is_correct");
                optionMap.put(i, isCorrect);
                displayMap.put(i, text);
                System.out.println(i + ". " + text);
                i++;
            }

            System.out.print("Your answer (1-4): ");
            int userChoice = scanner.nextInt();
            boolean correct = optionMap.getOrDefault(userChoice, false);
            System.out.println(correct ? "Correct!" : "Wrong!");

            if (correct) score++;
            total++;

            AttemptDAO.insertAttemptDetail(attemptId, questionId, userChoice, correct);
        }

        AttemptDAO.updateScore(attemptId, score);
        System.out.println("\nQuiz completed. Your score: " + score + "/" + total);
    }
}
