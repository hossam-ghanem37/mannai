# Employee Management Microservice

## Overview
The **Employee Management Microservice** is a Spring Boot application that provides CRUD (Create, Read, Update, Delete) operations for managing employee records. It runs on port **8080** and uses an **H2 in-memory database** for data persistence.

## Technologies Used
- **Spring Boot** (REST API Development)
- **Spring Data JPA** (Database interaction)
- **H2 Database** (In-memory database)
- **MapStruct** (Entity to DTO mapping)
- **Spring Validation** (Data validation)
- **Lombok** (Boilerplate code reduction)

## Prerequisites
Ensure you have the following installed:
- **Java 17**
- **Gradle**
- **Git**

## How to Run the Application

### Clone the Repository
```sh
 git clone https://github.com/hossam-ghanem37/mannai.git
 cd mannai
```

### Run the Application with Gradle
```sh
 ./gradlew bootRun
```

## API Endpoints
### 1. Add a New Employee
**POST v1/api/employee**
```json
{
  "name": "Hossam Ghanem",
  "department": "Dev",
  "salary": 5000.0
}
```

```console
curl -X POST "http://localhost:8080/v1/api/employee" \
     -H "Content-Type: application/json" \
     -d '{"name": "John Doe", "department": "Engineering", "salary": 60000}'

```
### 2. Retrieve All Employees (Paginated)
**GET v1/api/employee?page=0&size=10**

```console
curl -X GET "http://localhost:8080/v1/api/employee?page=0&size=10"

```
### 3. Retrieve Employee by ID
**GET v1/api/employee/{id}**
```console
curl -X GET "http://localhost:8080/v1/api/employee/1"
```

### 4. Update an Employee
**PUT v1/api/employee/{id}**
```json
{
  "name": "Hossam Mohamed",
  "department": "HR",
  "salary": 6000.0
}
```
```console
curl -X PUT "http://localhost:8080/v1/api/employee/1" \
     -H "Content-Type: application/json" \
     -d '{
           "name": "John Doe",
           "department": "HR",
           "salary": 70000
         }'
```

### 5. Delete an Employee
**DELETE v1/api/employee/{id}**

```console
curl -X DELETE "http://localhost:8080/v1/api/employee/1"
```

## Database Access (H2 Console)
- **URL:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** *(Leave blank)*

