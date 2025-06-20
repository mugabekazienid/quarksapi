# Quarks Group Backend Internship - Technical Test

This is a simple REST API built with Spring Boot for the Quarks Group internship assessment.

Endpoints

### `POST /users`

### Create a new user.

Request Body (JSON):
{
  "name": "Alice",
  "email": "alice@example.com"
}

Response:
{
  "id": "uuid-generated-id",
  "name": "Alice",
  "email": "alice@example.com"
}
GET /users/{id}
### Retrieve a user by ID.

Response:
{
  "id": "uuid-generated-id",
  "name": "Alice",
  "email": "alice@example.com"
}
If not found:

{
  "error": "User not found"
}

### Technology Used
Java 17

Spring Boot 3.5.2

Maven

### How to Run
Make sure Java 17 and Maven are installed.

Clone the repository.

Run:

mvn spring-boot:run

API will be available at: http://localhost:8080

Example Test Commands

# Create user
curl -X POST http://localhost:8080/users -H "Content-Type: application/json" -d "{\"name\":\"Alice\",\"email\":\"alice@example.com\"}"

# Get user by ID
curl http://localhost:8080/users/{user-id}

