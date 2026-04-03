# Finance Dashboard Backend

## 📌 Overview
The **Finance Dashboard Backend** is a Spring Boot application designed to manage financial records with **role-based access control**. It provides RESTful APIs for user management, financial records, and dashboard summaries.

---

## 🛠 Tech Stack
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (in-memory)
- **Maven**

---

## ✨ Features
- User and role management (**ADMIN**, **ANALYST**, **VIEWER**)
- CRUD operations for financial records
- Filtering by **type**, **category**, and **date**
- Dashboard summary (income, expenses, balance)
- Role-based access control
- Input validation and error handling

---

## 📡 API Endpoints

### 👤 Users
- `POST /users` → Create user  
- `GET /users` → Get all users  

### 💰 Records
- `POST /records` → Create record (**ADMIN only**)  
- `GET /records` → Get all records  
- `DELETE /records/{id}` → Delete record (**ADMIN only**)  
- `GET /records/type` → Filter by type  
- `GET /records/category` → Filter by category  
- `GET /records/date` → Filter by date range  

### 📊 Summary
- `GET /summary` → Get financial summary  

---

## 🔒 Access Control
- **VIEWER** → Read only  
- **ANALYST** → Read + insights  
- **ADMIN** → Full access  

---

## 🚀 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/Finance-Dashboard-Backend.git

2. Navigate to the project directory:
   ```bash
   cd Finance-Dashboard-Backend

3. Run the application:
   ```bash
   mvn spring-boot:run

4. Open in browser:
   ```bash
   http://localhost:8080

---

## 🧪 Testing

  Use Postman to test APIs.
 
  Add header:
  `Role: ADMIN / ANALYST / VIEWER`

---

## 🗄 Database

  H2 in-memory database
 
  Console available at: `http://localhost:8080/h2-console`

---

## 📖 Assumptions

- Role is passed via request header
- No authentication implemented
- Data is temporary (in-memory)


