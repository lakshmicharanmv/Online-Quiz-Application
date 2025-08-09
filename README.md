# 📚 Online Quiz Application

A Java-based console application for conducting and managing online quizzes.  
This project provides a backend system where users can register, attempt quizzes, and view results, while administrators can create and manage quizzes.  
It is ideal for educational institutions or training programs to efficiently conduct assessments.

---

## 📝 Description

The **Online Quiz Application** is built using **Java, JDBC, and MySQL**.  
It supports:
- User authentication (students & admins)
- Quiz creation and question management
- Real-time scoring and leaderboard tracking
- Detailed performance history

The application follows a modular structure with DAO classes for database operations and uses MySQL Connector/J for database connectivity.

## 🚀 How to Use

1. **Setup Database**
   - Create a database `quiz_app` in MySQL.
   - Run the `schema.sql` file to create necessary tables.
   - (Optional) Import `test_data.sql` for sample quizzes.

2. **Configure Database Connection**
   - Open `DBConnection.java` and update:
     ```java
     private static final String URL = "jdbc:mysql://localhost:3306/quiz_app";
     private static final String USER = "your_username";
     private static final String PASSWORD = "your_password";
     ```

3. **Run the Application**
   - Compile:
     ```bash
     javac -cp ".;lib/*" src/*.java
     ```
   - Execute:
     ```bash
     java -cp ".;lib/*;src" Main
     ```

4. **Using the Application**
   - **Students**: Log in → Select a quiz → Answer → View score/leaderboard.
   - **Admins**: Log in → Create/manage quizzes → Add/edit questions → View results.

## 🗃️ Project Structure

```
Online-Quiz-Application/
├── src/
│   ├── DBConnection.java     # Manages database connections
│   ├── UserDAO.java          # Handles user authentication
│   ├── QuizDAO.java          # Manages quiz operations
│   ├── QuestionDAO.java      # Handles question bank
│   ├── AttemptDAO.java       # Manages quiz attempts
│   ├── LeaderboardDAO.java   # Handles leaderboard
│   ├── QuizService.java      # Core quiz logic
│   └── Main.java             # Application entry point
├── lib/
│   └── mysql-connector-j-9.4.0.jar
├── schema.sql                # Database schema
├── test_data.sql             # Sample data
└── README.md
```

## 🔧 Troubleshooting

- **Connection Issues**: Ensure MySQL server is running and credentials are correct
- **Class Not Found**: Verify MySQL Connector JAR is in `lib/`
- **SQL Errors**: Check if tables were created using schema.sql

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.



Developed for learning and educational purposes.
