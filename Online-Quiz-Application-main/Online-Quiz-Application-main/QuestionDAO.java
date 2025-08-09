import java.sql.*;
import java.util.*;

public class QuestionDAO {

    public static int addQuestion(int quizId, String questionText) throws SQLException {
        int questionId = -1;
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO questions (quiz_id, question_text) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, quizId);
            ps.setString(2, questionText);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                questionId = rs.getInt(1);
            }
        }
        return questionId;
    }

    public static void addOption(int questionId, String optionText, boolean isCorrect) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO options (question_id, option_text, is_correct) VALUES (?, ?, ?)");
            ps.setInt(1, questionId);
            ps.setString(2, optionText);
            ps.setBoolean(3, isCorrect);
            ps.executeUpdate();
        }
    }

    public static ResultSet getQuestionsForQuiz(int quizId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM questions WHERE quiz_id = ?");
        ps.setInt(1, quizId);
        return ps.executeQuery();
    }

    public static ResultSet getOptionsForQuestion(int questionId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM options WHERE question_id = ?");
        ps.setInt(1, questionId);
        return ps.executeQuery();
    }
}
