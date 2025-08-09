import java.sql.*;
import java.util.*;

public class QuizDAO {

    public static void createQuiz(String title, String topic, int userId) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO quizzes (title, topic, created_by) VALUES (?, ?, ?)");
            ps.setString(1, title);
            ps.setString(2, topic);
            ps.setInt(3, userId);
            ps.executeUpdate();
        }
    }

    public static void deleteQuiz(int quizId) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM quizzes WHERE id = ?");
            ps.setInt(1, quizId);
            ps.executeUpdate();
        }
    }

    public static void updateQuiz(int quizId, String newTitle, String newTopic) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE quizzes SET title = ?, topic = ? WHERE id = ?");
            ps.setString(1, newTitle);
            ps.setString(2, newTopic);
            ps.setInt(3, quizId);
            ps.executeUpdate();
        }
    }

    public static ResultSet getAllQuizzes() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery("SELECT * FROM quizzes");
    }
}

