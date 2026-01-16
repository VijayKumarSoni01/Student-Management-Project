🎓 **Student & Attendance Management System**

# 🚀 Spring Boot Microservices with 🔐 Role-Based Security
📌 Project Overview

The application is divided into three independent Spring Boot applications working together using a microservices architecture.
Both business services are secured using Spring Security with role-based authorization.

# 🎓 StudentManagement Service
- Responsibilities

- Manages student details

- Adds and stores student information

- Generates a unique roll number for each student

- Provides REST APIs to fetch student data

- Registers itself with Eureka Server

# Security

- Spring Security implemented

- Role-based access control

- Secured REST endpoints

- Centralized authentication logic

# 🗄️ Database

- student_db

# 🗓️ AttendanceManagement Service
- Responsibilities

- Manages daily student attendance

- Marks attendance as PRESENT, ABSENT, or LEAVE

- Automatically stores attendance date

- Fetches student details from StudentManagement

- Inter-Service Communication

- Uses Feign Client

- Service discovery via Eureka Server

- No hardcoded URLs or ports

# Security

- Spring Security implemented

- Role-based access control

- Endpoint-level authorization

- Secure inter-service communication

# 🗄️ Database

- attendance_db

# 🧭 Eureka Server
- Responsibilities

- Acts as a service registry

- All microservices register here

- Enables dynamic service discovery

- Eliminates hardcoded hostnames and ports

- Microservices Architecture

- Independent Spring Boot applications

- Separate databases for each service

- REST-based inter-service communication

- Service discovery using Eureka Server

- Declarative REST calls using Feign Client

- Spring Security with role-based authorization

- No shared entities or repositories

- Clean separation of concerns

- Scalable and production-style design

# 🛠️ Tech Stack

- ☕ Java 21

- 🌱 Spring Boot

- 🔐 Spring Security

- ☁️ Spring Cloud (Eureka, Feign)

- 🗃️ Spring Data JPA

- 🔄 REST APIs

- 🐬 MySQL

- 🧰 Lombok

- 📦 Maven

- 🐙 Git & GitHub

🔌 SERVICES & PORTS
🚀 SERVICE	🔢 PORT	🗄️ DATABASE
🧭 EUREKA SERVER	8761	—
🎓 STUDENTMANAGEMENT	8080	STUDENT_DB
🗓️ ATTENDANCEMANAGEMENT	8081	ATTENDANCE_DB

✅ Services communicate using service names, not hardcoded ports.

# 🔐 Security Overview

- Spring Security enabled in both microservices

- Role-based authorization

- Secure API access

- Production-ready security configuration