
import java.sql.*;
import java.util.*;

public class AttemptDAO {

    public static int createQuizAttempt(int userId, int quizId) throws SQLException {
        int attemptId = -1;
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO quiz_attempts (user_id, quiz_id, score) VALUES (?, ?, 0)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userId);
            ps.setInt(2, quizId);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                attemptId = rs.getInt(1);
            }
        }
        return attemptId;
    }

    public static void insertAttemptDetail(int attemptId, int questionId, int selectedOptionId, boolean isCorrect) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO attempt_details (attempt_id, question_id, selected_option_id, is_correct) VALUES (?, ?, ?, ?)");
            ps.setInt(1, attemptId);
            ps.setInt(2, questionId);
            ps.setInt(3, selectedOptionId);
            ps.setBoolean(4, isCorrect);
            ps.executeUpdate();
        }
    }

    public static void updateScore(int attemptId, int score) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE quiz_attempts SET score = ? WHERE id = ?");
            ps.setInt(1, score);
            ps.setInt(2, attemptId);
            ps.executeUpdate();
        }
    }

    public static ResultSet getAttemptsForUser(int userId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM quiz_attempts WHERE user_id = ?");
        ps.setInt(1, userId);
        return ps.executeQuery();
    }
}
