# Todo Application

This is a Todo application built with Spring Boot backend, React frontend, and a PostgreSQL database. The app is containerized using Docker and supports both development and production environments with automatic proxying.

## Features
- **Add Todo**: Allows users to add new todo items.
- **Mark Todo as Completed**: Users can mark todo items as completed using a checkbox.
- **Delete Todo**: Users can delete todo items.

## Architecture

- **Backend**: Spring Boot REST API (running on port `8080`)
- **Frontend**: React (Running on port `5173` for development and `8081` for production)
- **Database**: PostgreSQL (Running on port `5432`)
- **Production**: Nginx (Serving on port `8081`)
- **Development**: Vite (Automatically proxies API requests to the backend)
- **Containerized with Docker**: Easily deploy and run with Docker compose.

## Setup Instructions

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Winter2024-NSCC-ECampus/assignment-01-web-app-Richardson902
   cd assignment-01-web-app-Richardson902
   ```

2. **Running the Application with Docker**:

   The application is containerized with Docker. To run the full application (both frontend and backend), simply use the following command:

   ```bash
   docker compose up --build
   ```

3. **Access the Application**
   - For **production version**, navigate to `http://localhost:8081`
   - For **development version**, the frontend will be available at `http://localhost:5173`
  
## How to Use the Application
- **Add a Todo**: Enter a new task description in the input field and click the "Add" button.
- **Mark Todo as Completed**: Click the checkbox next to a todo item to mark it as completed.
- **Delete Todo**: Click the trash can next to a todo item to remove it.

## Technologies Used
- **Backend**: Spring Boot
- **Frontend**: React
- **Database**: PostgreSQL
- **Production Server**: Nginx
- **Development Server**: Vite
- **Containerization**: Docker, Docker Compose

## Todo App Example
![image](https://github.com/user-attachments/assets/010cdb3c-2a2f-4b95-aa09-e37c58e4a68e)
