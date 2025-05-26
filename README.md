# 🎓 Student Record Management System (Java + MySQL)

A command-line based Student Record Management System built using **Java** and **MySQL**, allowing users to perform CRUD (Create, Read, Update, Delete) operations on student data. This project demonstrates JDBC connectivity, SQL integration, object-oriented principles, and user interaction using the console.

---

## 📌 Features

- 🔐 Unique Roll Number enforcement
- ✅ Add new student records
- 🔍 Search and display a student's details using roll number
- ✏️ Update specific student attributes (name, phone, age, class, marks)
- ❌ Delete student record
- 📋 Display all student records

---

## 🛠️ Technologies Used

- **Java** – Core programming language
- **JDBC (Java Database Connectivity)** – For MySQL connection
- **MySQL** – Relational database
- **SQL** – Query language to interact with DB
- **Scanner Class** – For console input

---

## ⚙️ Database Setup

1. Install MySQL and create a database named:

2. Create a table inside that DB:
```sql
CREATE TABLE studentinfo (
  rollno INT PRIMARY KEY,
  sname VARCHAR(100),
  sphone VARCHAR(15),
  sage INT,
  sclass INT,
  marks INT
);

3. Update the DB credentials in the code:
```java
String url = "jdbc:mysql://localhost:3306/studentdetails";
String user = "root";
String pass = "YOUR_PASSWORD_HERE";


