
# Spring Authors Project

In this project, there is a simple RESTful API application developed using Spring Boot. The application provides two main API endpoints to manage authors and their works.

## Prerequisites

To successfully run the project, the following tools need to be installed:

Java 11 or above
Maven 3.6 or above
MySQL Server 5.7 or above

## Installation and Configuration

You can install and run the project in your local environment by following these steps:


### 1. Clone the Project

Use the following commands to clone the project from GitHub:


```bash
git clone https://github.com/your-username/spring-authors-project.git
cd spring-authors-project
```

### 2. Configure the Database


Create a database in MySQL with the name your_database_name. Update the database username and password in the src/main/resources/application.properties file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
```

This configuration defines how the application will connect to the MySQL database.


### 3. Compile and Run the Application

Compile the project with Maven and create the JAR file:

```bash
mvn clean install
```

To run the application:

```bash
java -jar target/spring-authors-project-1.0-SNAPSHOT.jar
```

## API Usage

The application provides the following RESTful endpoints:

GET /api/authors: Lists all authors.
POST /api/authors: Adds a new author.
GET /api/authors/{name}: Retrieves an author with a specific name.
DELETE /api/authors/{id}: Deletes an author with a specific ID.
GET /api/works/author/{authorId}: Lists all works of an author.
POST /api/works: Adds a new work.
DELETE /api/works/{id}: Deletes a work with a specific ID.


## Testing

To test the application, you can use Postman or a similar API testing tool. Send appropriate HTTP requests for each endpoint and check the responses.


## Contribution

If you want to contribute to the project, please express your intention by opening an issue or by directly sending a pull request.

