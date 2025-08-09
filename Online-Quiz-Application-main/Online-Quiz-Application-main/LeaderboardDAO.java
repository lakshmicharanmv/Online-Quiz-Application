import java.sql.*;

public class LeaderboardDAO {

    public static ResultSet getTopScorersForQuiz(int quizId, int limit) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(
            "SELECT u.username, qa.score FROM quiz_attempts qa JOIN users u ON qa.user_id = u.id WHERE qa.quiz_id = ? ORDER BY qa.score DESC LIMIT ?");
        ps.setInt(1, quizId);
        ps.setInt(2, limit);
        return ps.executeQuery();
    }

    public static ResultSet getOverallTopScorers(int limit) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(
            "SELECT u.username, SUM(qa.score) AS total_score FROM quiz_attempts qa JOIN users u ON qa.user_id = u.id GROUP BY u.id ORDER BY total_score DESC LIMIT ?");
        ps.setInt(1, limit);
        return ps.executeQuery();
    }
}
