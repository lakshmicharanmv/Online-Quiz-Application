import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        try {
            while (running) {
                System.out.println("\n=== Online Quiz Application ===");
                System.out.println("1. Take a Quiz");
                System.out.println("2. View Leaderboard");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter Quiz ID: ");
                        int quizId = scanner.nextInt();
                        System.out.print("Enter User ID: ");
                        int userId = scanner.nextInt();
                        QuizService.takeQuiz(quizId, userId);
                        break;
                    case 2:
                        System.out.print("Enter Quiz ID to view leaderboard: ");
                        int leaderboardQuizId = scanner.nextInt();
                        ResultSet topScorers = LeaderboardDAO.getTopScorersForQuiz(leaderboardQuizId, 10);
                        System.out.println("\n=== Top Scorers ===");
                        System.out.println("Username\tScore");
                        System.out.println("----------------------");
                        while (topScorers.next()) {
                            System.out.println(topScorers.getString("username") + "\t\t" + 
                                             topScorers.getInt("score"));
                        }
                        break;
                    case 3:
                        running = false;
                        System.out.println("Thank you for using the Online Quiz Application!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
