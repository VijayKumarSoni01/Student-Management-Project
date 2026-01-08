# Project Overview

**The application is divided into three independent Spring Boot applications working together.**

# StudentManagement Service

- Manages student details

- Adds and stores student information

- Generates a unique roll number for each student

- Provides REST APIs to fetch student data

- Registers itself with Eureka Server

- Uses its own database: student_db

# AttendanceManagement Service

- Manages daily student attendance

- Marks attendance as PRESENT / ABSENT / LEAVE

- Automatically stores attendance date

- Fetches student details from StudentManagement

- Uses Feign Client for inter-service communication

- Uses Eureka for service discovery (no hardcoded URLs)

- Uses its own database: attendance_db

# Eureka Server

- Acts as a service registry

- All microservices register here

- Enables dynamic service discovery

- Eliminates hardcoded hostnames and ports

# Microservices Architecture

- Independent Spring Boot applications

- Separate databases for each service

- REST-based communication between services

- Service discovery using Eureka Server

- Declarative REST calls using Feign Client

- No shared entities or repositories

- Clean separation of concerns

- Scalable and production-style design

# Tech Stack

- Java 21

- Spring Boot

- Spring Cloud (Eureka, Feign)

- Spring Data JPA

- REST APIs

- MySQL

- Lombok

- Maven

- Git & GitHub

# Services & Ports

--
| Service | Port | Database |
|------|------|---------|
| Eureka Server | 8761 | -- |
| StudentManagement | 8080 | student_db |
| AttendanceManagement | 8081 | attendance_db |

--

Services communicate using service names, not hardcoded ports.