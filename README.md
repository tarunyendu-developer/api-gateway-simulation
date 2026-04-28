# 🚀 API Gateway Simulation System – Spring Boot

## 📌 Project Overview

The API Gateway Simulation System is a Spring Boot-based application that simulates the behavior of an API Gateway. It receives incoming HTTP requests, validates them using an API key, routes them to appropriate internal services (User, Product, Order), and logs all request details into a database.

This project demonstrates key backend concepts such as routing, security, logging, layered architecture, and RESTful API design.

---

## 🎯 Features

### ✅ API Gateway Functionality

* Routes requests based on URL path:

    * `/api/users`
    * `/api/products`
    * `/api/orders`
    * `/api/logs`

### ✅ CRUD Operations

* User Service (Create, Read, Delete)
* Product Service (Create, Read, Delete)
* Order Service (Create, Read, Delete)

### ✅ API Key Security

* Implemented using `OncePerRequestFilter`
* Validates `X-API-KEY` header for every request
* Rejects unauthorized requests with **401 Unauthorized**

### ✅ Request Logging

* Logs every API request with:

    * Request URL
    * HTTP Method
    * Timestamp
    * Response Status
* Stores logs in database (`request_logs` table)

### ✅ Validation

* Input validation using:

    * `@NotBlank`
    * `@Email`
* Ensures proper request data

### ✅ Exception Handling

* Global exception handler for:

    * Clean error responses
    * Proper HTTP status codes

### ✅ Layered Architecture

* Controller → Service → Repository → Entity

---

## 🛠️ Technologies Used

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* MySQL
* Lombok
* Maven

---

## 🗄️ Database Tables

### 1. Users

* id
* name
* email
* role
* created_at

### 2. Products

* id
* name
* category
* price
* stock
* created_at

### 3. Orders

* id
* user_id
* product
* quantity
* total_price
* status
* created_at

### 4. Request Logs

* id
* request_url
* http_method
* request_time
* response_status

---

## 🔗 API Endpoints

### 👤 Users

* `GET /api/users`
* `GET /api/users/{id}`
* `POST /api/users`
* `DELETE /api/users/{id}`

### 📦 Products

* `GET /api/products`
* `GET /api/products/{id}`
* `POST /api/products`
* `DELETE /api/products/{id}`

### 🛒 Orders

* `GET /api/orders`
* `GET /api/orders/{id}`
* `POST /api/orders`
* `DELETE /api/orders/{id}`

### 📊 Logs

* `GET /api/logs`

---

## 🔐 API Security

All APIs require the following header:

X-API-KEY: secret123

---

## ▶️ How to Run the Project

1. Clone the repository

2. Open in IntelliJ or any IDE

3. Configure MySQL in `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/api_gateway_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

4. Run the application

5. Test APIs using Postman

---

## 🧪 Testing

* All APIs tested using Postman
* Verified:

    * CRUD operations
    * API key validation
    * Request logging
    * Error handling
    * Validation

---

## 📦 Deliverables

* Complete Spring Boot source code
* Working REST APIs
* Database integration (MySQL)
* Request logging system
* API security using API key

---

## 🎯 Conclusion

This project successfully simulates an API Gateway by handling routing, security, logging, and request processing. It follows best practices in backend development and demonstrates strong understanding of Spring Boot and RESTful API design.

---

## 👨‍💻 Author

Tarun Yendu
