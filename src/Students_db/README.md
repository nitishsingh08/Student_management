# Student Management System

A console-based Student Management System built using **Java, JDBC, and MySQL**.

This project allows users to manage student records such as adding students, searching by roll number, updating marks, and deleting records.

---

## Features

- Add Student
- Search Student by Roll Number
- Update Student Marks
- Delete Student
- Display All Students in Table Format
- Automatic Percentage Calculation

---

## Technologies Used

- Java
- JDBC
- MySQL
- IntelliJ IDEA

---

## Database Setup

Run the following SQL queries in MySQL:

CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students(
roll_no INT PRIMARY KEY,
name VARCHAR(100),
age INT,
course VARCHAR(50),
maths INT,
chemistry INT,
physics INT
);

---

## How to Run the Project

1. Clone the repository

git clone https://github.com/nitishsingh08/Student_management.git

2. Open the project in IntelliJ IDEA

3. Add MySQL Connector (JDBC driver)

4. Configure database connection in `DBConnection.java`

5. Run `Main.java`

---

## Example Output

Roll     Name        Age   Course   Maths  Chem  Phy  Percent
--------------------------------------------------------------
1        Nitish      20    E&TC     85     90    80   85.00