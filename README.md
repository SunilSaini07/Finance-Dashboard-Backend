# Finance Dashboard Backend

## 📌 Overview

The **Finance Dashboard Backend** is a Spring Boot application designed to manage financial records with **role-based access control**. It provides RESTful APIs for user management, financial records, and dashboard summaries.

---

## 🌐 Live Deployment
This project is deployed on Render with Neon PostgreSQL as the database.

Live URL:  
👉 https://finance-dashboard-backend-09nx.onrender.com

---

## 🛠 Tech Stack

* **Java**
* **Spring Boot**
* **Spring Data JPA**
* **PostgreSQL** (persistent database, hosted on Neon)
* **Maven**
* **AI Tool**
* **Render** (deployment platform)

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

3. Configure PostgreSQL in `application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/finance_db?sslmode=require
   spring.datasource.username=your_username
   spring.datasource.password=your_password

   ```

4. Make sure PostgreSQL is running and create database:

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

* **PostgreSQL database (persistent storage via Neon)**
* Tables are automatically created using JPA

---

## 📖 Assumptions

* Role is passed via request header
* No authentication implemented
* PostgreSQL is used for persistent storage

---

