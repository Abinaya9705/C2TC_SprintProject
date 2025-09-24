# Placement Management System

This is a Spring Boot project for managing placement activities. The project includes a College module with full CRUD operations.

## Features
- College Entity: Add, view, update, and delete colleges
- REST API endpoints for college management
- In-memory H2 database for demo purposes

## How to Run
1. Make sure you have Java 17+ and Maven installed.
2. Open a terminal in the project root folder.
3. Run the following command to build and start the application:
   
   ```powershell
   mvn spring-boot:run
   ```
4. Access the H2 console at [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
5. Use the following REST endpoints:
   - `POST /api/colleges` - Add a new college
   - `GET /api/colleges` - List all colleges
   - `GET /api/colleges/{id}` - Get college by ID
   - `PUT /api/colleges/{id}` - Update college
   - `DELETE /api/colleges/{id}` - Delete college

## Example JSON for College
```
{
  "name": "ABC College",
  "address": "123 Main St",
  "email": "info@abccollege.edu",
  "phone": "9876543210"
}
```

## Next Steps
- Add more modules (students, placements, etc.) as needed
- Replace H2 with MySQL or another database for production
