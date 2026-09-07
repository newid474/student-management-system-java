CREATE DATABASE IF NOT EXISTS student_management;

USE student_management;

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15),
    department VARCHAR(50),
    year INT,
    marks DOUBLE
);

INSERT INTO students
(name, email, phone, department, year, marks)
VALUES
('Aishu', 'aishu@example.com', '9876543210', 'CSE', 3, 92),
('Akshaya', 'akshaya@example.com', '9876543211', 'CSE', 3, 85),
('Rakshana', 'rakshana@example.com', '9876543212', 'CSE', 3, 78);

SELECT * FROM students;
