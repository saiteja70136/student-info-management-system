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
```
3. Update the DB credentials in the code:
```java
String url = "jdbc:mysql://localhost:3306/studentdetails";
String user = "root";
String pass = "YOUR_PASSWORD_HERE";
```



## ▶️ How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/student-record-system.git
   cd student-record-system
   ```

2. Compile and run the project:

   ```bash
   javac studentrecodesystem.java
   java studentrecodesystem
   ```

3. Follow the CLI instructions to manage student records.

---

## 🧠 Learning Highlights

* JDBC connection and error handling
* SQL integration for real-world apps
* Object-Oriented Design (OOP)
* Clean, modular Java code
* CLI-based user interface

---

## 🚀 Future Improvements

* GUI integration using Swing or JavaFX
* Input validation and exception handling improvements
* Use of PreparedStatements to prevent SQL Injection
* Add pagination and filtering for large datasets
* Unit testing using JUnit

```

## 🙌 Author

* 👤 **K Naga Sai Teja**
* 🔗 [LinkedIn](https://www.linkedin.com/in/sai-teja-00378622a/)
* 📫 Email:saitej3140@gmail.com

---

## 📄 License

This project is licensed under the MIT License.

---

