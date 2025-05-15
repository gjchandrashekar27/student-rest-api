🎓 Student REST API

A simple Spring Boot application for managing student records with full CRUD operations, pagination, and sorting.

🌟 Features

Create a single student record

Create multiple student records in batch

Fetch records with pagination and sorting

Edit (update) student details

Delete student records

🚀 Tech Stack

Java 17

Spring Boot

Spring Data JPA

Hibernate

MySQL (or any relational DB)

Lombok

Maven

🗂️ API Endpoints

Base URL: http://localhost:8080/api/v1

Available Mappings:

➕ Create single studentPOST /api/v1/student

➕➕ Create multiple studentsPOST /api/v1/students

📥 Fetch students list (with pagination & sorting)GET /api/v1/students

🔍 Fetch single student by IDGET /api/v1/student/{id}

✏️ Update student by IDPUT /api/v1/student/{id}

🗑️ Delete student by IDDELETE /api/v1/student/{id}

🤝 Contributing

Feel free to open issues or pull requests. ⭐️ your contributions!

Made with ❤️ by Chandrashekar GJ
