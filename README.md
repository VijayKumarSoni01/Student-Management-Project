# Student-Management-Project

This project is a **Student Management System built using Spring Boot Microservices**.  
It consists of two independent services that work together to manage **student details** and **attendance records** in a clean and scalable way.

This project is created to understand **real-world backend development**, **microservices architecture**, and **REST-based service communication**.

---

## Project Overview

The system is divided into **two independent microservices**, each handling a specific responsibility.

# StudentManagement Service
- Manages student details  
- Adds and stores student information  
- Generates a unique roll number for each student  
- Provides APIs to fetch student data  
- Uses its own database: `student_db`  

# AttendanceManagement Service
- Manages student attendance  
- Marks attendance as **PRESENT / ABSENT / LEAVE**  
- Automatically stores attendance date  
- Communicates with StudentManagement service via REST APIs  
- Uses its own database: `attendance_db`  

---

# Microservices Architecture

- Independent Spring Boot applications  
- Separate databases for each service  
- REST-based inter-service communication  
- No shared entities or repositories  
- Clean separation of concerns  
- Scalable and maintainable design  

# Tech Stack

- Java  
- Spring Boot  
- Spring Data JPA  
- REST APIs  
- MySQL  
- Lombok  
- Maven  
- Git & GitHub  

# Services & Ports

| Service | Port | Database |
|------|------|---------|
| StudentManagement | 8080 | student_db |
| AttendanceManagement | 8081 | attendance_db |

---
