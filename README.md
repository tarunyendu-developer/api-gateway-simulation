# 🚀 API Gateway Simulation System – Spring Boot

## 📌 Overview

This project is a **Spring Boot-based API Gateway Simulation System** that demonstrates how an API Gateway works in a microservices architecture. The application receives incoming HTTP requests, validates them using a custom API key, routes them to appropriate internal services (User, Product, Order), and logs all request details into a database.

The project follows a **layered architecture (Controller → Service → Repository → Entity)** and integrates with a **MySQL database**.

---

## 🎯 Objective

To simulate the behavior of an API Gateway by:

* Accepting incoming requests
* Routing requests based on URL path
* Securing APIs using API key validation
* Logging request details into the database
* Returning structured JSON responses

---

## ⚙️ Tech Stack

| Technology      | Description             |
| --------------- | ----------------------- |
| Java 17         | Programming Language    |
| Spring Boot     | Backend Framework       |
| Spring Web      | REST API Development    |
| Spring Data JPA | Database Interaction    |
| MySQL           | Database                |
| Lombok          | Reduce Boilerplate Code |
| Maven           | Build Tool              |

---

## 🏗️ Architecture

The project follows a **layered architecture**:

Controller → Handles HTTP requests
Service → Contains business logic
Repository → Handles database operations
Entity → Maps database tables

---

## 🔐 API Security (API Key Filter)

A custom filter (`OncePerRequestFilter`) is implemented to:

* Validate the presence of `X-API-KEY` in every request
* Reject unauthorized requests with **401 Unauthorized**

### Required Header:

```
X-API-KEY: secret123
```

---

## 🔄 Request Routing

The API Gateway routes requests based on URL paths:

| Endpoint      | Service         |
| ------------- | --------------- |
| /api/users    | User Service    |
| /api/products | Product Service |
| /api/orders   | Order Service   |
| /api/logs     | Logging Service |

---

## 📊 Logging Mechanism

Every request is logged in the database with:

* Request URL
* HTTP Method
* Request Timestamp
* Response Status

### Table: `request_logs`

| Field           | Description   |
| --------------- | ------------- |
| id              | Primary Key   |
| request_url     | API URL       |
| http_method     | HTTP Method   |
| request_time    | Timestamp     |
| response_status | Response Code |

---

## 🗄️ Database Schema

### 1. Users Table

| Field      | Type      |
| ---------- | --------- |
| id         | Long      |
| name       | String    |
| email      | String    |
| role       | String    |
| created_at | Timestamp |

---

### 2. Products Table

| Field      | Type      |
| ---------- | --------- |
| id         | Long      |
| name       | String    |
| category   | String    |
| price      | Double    |
| stock      | Integer   |
| created_at | Timestamp |

---

### 3. Orders Table

| Field       | Type      |
| ----------- | --------- |
| id          | Long      |
| user_id     | Long      |
| product     | String    |
| quantity    | Integer   |
| total_price | Double    |
| status      | String    |
| created_at  | Timestamp |

---

## 📡 API Endpoints

### 👤 User APIs

* GET `/api/users`
* GET `/api/users/{id}`
* POST `/api/users`
* DELETE `/api/users/{id}`

---

### 📦 Product APIs

* GET `/api/products`
* GET `/api/products/{id}`
* POST `/api/products`
* DELETE `/api/products/{id}`

---

### 🛒 Order APIs

* GET `/api/orders`
* GET `/api/orders/{id}`
* POST `/api/orders`
* DELETE `/api/orders/{id}`

---

### 📜 Logs API

* GET `/api/logs`

---

## ✅ Validation

Input validation is implemented using:

* `@NotBlank`
* `@Email`
* `@Valid`

Ensures:

* No empty fields
* Proper email format

---

## ⚠️ Exception Handling

A global exception handler is implemented to:

* Return clean JSON error responses
* Handle runtime and validation exceptions

Example:

```json
{
  "message": "User not found",
  "status": 404
}
```

---

## ▶️ How to Run the Project

### Step 1: Clone Repository

```
git clone https://github.com/tarunyendu-developer/api-gateway-simulation.git
```

### Step 2: Configure Database

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/api_gateway_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Step 3: Run Application

* Open project in IntelliJ
* Run main class

---

## 🧪 Testing

APIs tested using Postman with:

* Valid API Key
* Invalid API Key
* Valid and invalid inputs

Verified:

* CRUD operations
* Security filter
* Logging functionality
* Validation errors
* Exception handling

---

## 📦 Deliverables

* Complete Spring Boot project
* Working REST APIs
* MySQL database integration
* API key security
* Request logging system
* Validation and exception handling

---

## 🎯 Project Highlights

* Simulates real API Gateway behavior
* Implements security using filters
* Logs request lifecycle data
* Follows clean architecture
* Uses DTO for better API design

---

## 👨‍💻 Author

**Tarun Yendu**
