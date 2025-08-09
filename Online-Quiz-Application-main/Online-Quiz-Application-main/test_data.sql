-- Insert a test user (password: test123)
INSERT INTO users (username, password_hash, email) VALUES 
('testuser', '$2a$10$N9qo8uLOickgx2ZMRZoMy.MH1JmG0f6hB/7M3k4DOKMQ6dDE/9H3a', 'test@example.com');

-- Insert a test quiz
INSERT INTO quizzes (title, topic, created_by) VALUES 
('General Knowledge Quiz', 'General', 1);

-- Insert questions for the quiz
INSERT INTO questions (quiz_id, question_text) VALUES 
(1, 'What is the capital of France?'),
(1, 'What is 2 + 2?'),
(1, 'Which planet is known as the Red Planet?');

-- Insert options for the first question
INSERT INTO options (question_id, option_text, is_correct) VALUES 
(1, 'London', 0),
(1, 'Paris', 1),
(1, 'Berlin', 0),
(1, 'Madrid', 0);

-- Insert options for the second question
INSERT INTO options (question_id, option_text, is_correct) VALUES 
(2, '3', 0),
(2, '4', 1),
(2, '5', 0),
(2, '2', 0);

-- Insert options for the third question
INSERT INTO options (question_id, option_text, is_correct) VALUES 
(3, 'Venus', 0),
(3, 'Mars', 1),
(3, 'Jupiter', 0),
(3, 'Saturn', 0);
