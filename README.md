# Machine Coding Assignment

## Project Overview
This is a backend system for the **Prodigy Program** providing a **5-minute per day plan** for users. It exposes REST APIs that serve activities for each day of a month-long program, which users can mark as **complete** to track progress.

## Technology Stack
- **Backend Framework**: Spring Boot
- **Database**: MySQL
- **JPA**: Hibernate ORM
- **Build Tool**: Maven

## API Endpoints

### 1. Get Activities for a Specific Day
- **Endpoint**: `GET /api/activities`
- **Query Parameter**: `day` (e.g., 14 for Day 14)
- **Description**: Fetches the activities for the specified day.
- **Example Request**:
    ```http
    GET http://localhost:8080/api/activities?day=14
    ```
- **Response Example**:
    ```json
    [
      {
        "id": 1,
        "title": "Exercise",
        "description": "Do 5 minutes of stretching",
        "day": 14
      },
      {
        "id": 2,
        "title": "Read",
        "description": "Read a motivational quote",
        "day": 14
      }
    ]
    ```

### 2. Mark an Activity as Complete
- **Endpoint**: `POST /api/activities/mark-complete`
- **Request Body**: 
    ```json
    {
      "userId": 1,
      "activityId": 1
    }
    ```
- **Description**: Marks the activity as complete for the given user.
- **Example Request**:
    ```http
    POST http://localhost:8080/api/activities/mark-complete
    ```
- **Response Example**:
    ```json
    {
      "message": "Activity marked as complete"
    }
    ```

### 3. Get User's Progress
- **Endpoint**: `GET /api/activities/progress/{userId}`
- **Description**: Fetches the list of activities a user has completed.
- **Example Request**:
    ```http
    GET http://localhost:8080/api/activities/progress/1
    ```
- **Response Example**:
    ```json
    [
      {
        "activityId": 1,
        "completed": true
      },
      {
        "activityId": 2,
        "completed": false
      }
    ]
    ```

## How to Run the Project Locally

### Prerequisites
- **JDK** 17 or higher
- **Maven** 3.8 or higher
- **MySQL** running on localhost:3306

### Setup
1. Clone this repository:
    ```sh
    git clone https://github.com/yourusername/Machine-Coding-Assignment.git
    cd Machine-Coding-Assignment
    ```
2. Create a MySQL database named `machine_coding`:
    ```sql
    CREATE DATABASE machine_coding;
    ```
3. Update the `application.properties` with your database credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/machine_coding?useSSL=false&allowPublicKeyRetrieval=true
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    ```

4. Run the application:
    ```sh
    mvn spring-boot:run
    ```

5. The app should now be running on `http://localhost:8080`.

## Testing the Endpoints
Use **Postman** or **curl** to test the above endpoints. Example using **curl**:
```sh
curl -X GET "http://localhost:8080/api/activities?day=14"
