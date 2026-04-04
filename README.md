# Finance Dashboard Backend

## 📌 Overview

The **Finance Dashboard Backend** is a Spring Boot application designed to manage financial records with **role-based access control**. It provides RESTful APIs for user management, financial records, and dashboard summaries.

---

## 🛠 Tech Stack

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **MySQL** (persistent database)
* **Maven**
* **AI Tool**

---

## ✨ Features

* User and role management (**ADMIN**, **ANALYST**, **VIEWER**)
* CRUD operations for financial records
* Filtering by **type**, **category**, and **date**
* Dashboard summary (income, expenses, balance)
* Role-based access control
* Input validation and error handling

---

## 📡 API Endpoints

### 👤 Users

* `POST /users` → Create user
* `GET /users` → Get all users

### 💰 Records

* `POST /records` → Create record (**ADMIN only**)
* `GET /records` → Get all records
* `DELETE /records/{id}` → Delete record (**ADMIN only**)

### 🔍 Filtering APIs

* `GET /records/type?type=income` → Filter by type
* `GET /records/category?category=salary` → Filter by category
* `GET /records/date?start=YYYY-MM-DD&end=YYYY-MM-DD` → Filter by date range

---

### 📊 Summary

* `GET /summary` → Get financial summary (**ADMIN & ANALYST only**)

---

## 🔒 Access Control

* **VIEWER** → Read only
* **ANALYST** → Read + insights (including summary)
* **ADMIN** → Full access

---

## 🚀 How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/Finance-Dashboard-Backend.git
   ```

2. Navigate to the project directory:

   ```bash
   cd Finance-Dashboard-Backend
   ```

3. Configure MySQL in `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

4. Make sure MySQL is running and create database:

   ```sql
   CREATE DATABASE finance_db;
   ```

5. Run the application:

   ```bash
   mvn spring-boot:run
   ```

6. Access APIs:

   ```bash
   http://localhost:8080
   ```

---

## 🧪 Testing

Use Postman to test APIs.

Add header:

```
Role: ADMIN / ANALYST / VIEWER
```

---

## 🗄 Database

* **MySQL database (persistent storage)**
* Tables are automatically created using JPA

---

## 📖 Assumptions

* Role is passed via request header
* No authentication implemented
* MySQL is used for persistent storage

---

