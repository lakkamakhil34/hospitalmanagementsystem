# hospitalmanagementsystem


# 🏥 Hospital Management System

## 📌 Project Overview
The Hospital Management System is a backend application developed using Java and Spring Boot. It helps manage hospital information by maintaining patient and doctor records through RESTful APIs.

This project demonstrates CRUD operations, database connectivity, and backend application development.

## 🛠️ Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST APIs
- Eclipse IDE
- Postman

## ✨ Features

### 👨‍⚕️ Doctor Management
- Add new doctor details
- Retrieve doctor information
- View all doctors
- Update doctor details
- Delete doctor records

### 🧑‍⚕️ Patient Management
- Register new patients
- Retrieve patient details
- View all patients
- Update patient information
- Delete patient records

## 🗂️ Project Structure

```text
HospitalManagementSystem
│
├── src/main/java
│   └── com.example.hospitalmanagementsystem
│       ├── Patient.java
│       ├── PatientRepository.java
│       ├── PatientController.java
│       ├── Doctor.java
│       ├── DoctorRepository.java
│       └── DoctorController.java
│
├── src/main/resources
│   └── application.properties
│
└── pom.xml
```

## ⚙️ Database Configuration

Configure your MySQL database in `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospitaldb
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

## 🚀 How to Run the Project

1. Clone this repository.
2. Import the project into Eclipse IDE.
3. Create a MySQL database.
4. Configure database credentials in `application.properties`.
5. Update Maven dependencies.
6. Run the Spring Boot application.
7. Test REST APIs using Postman.

## 🎯 Learning Outcomes

- Understanding Spring Boot application development.
- Implementing RESTful web services.
- Performing CRUD operations.
- Connecting Java applications with MySQL.
- Working with Spring Data JPA and Hibernate.
- Understanding Controller and Repository layers.

Java | Spring Boot | MySQL | Backend Development

---

⭐ If you find this project useful, feel free to explore the repository!
