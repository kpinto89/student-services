# student-services

This application demonstrates how to implement CRUD operations with a `Student` entity.

## What's inside
This project is based on the [Spring Boot](http://projects.spring.io/spring-boot/) project and uses these packages :
- Maven
- Spring Core
- Spring Data (H2)
- Spring MVC (Tomcat)

## Installation
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

## Database configuration
Create a MySQL database with the name `studentdb` and add the credentials to `/resources/application.properties`.  
The default ones are :

```
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:studentdb
spring.datasource.username=dbuser
spring.datasource.password=dbpass
spring.jpa.hibernate.ddl-auto=update
```

## Usage
```
server.port = 8081
```
Run the project through the IDE and head out to [http://localhost:8081](http://localhost:8081)

or

run this command in the command line:
```
mvn spring-boot:run
```