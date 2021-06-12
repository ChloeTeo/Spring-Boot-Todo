# Spring-Boot-Todo
Using Spring Boot and Thymeleaf for a simple todo page

Prerequisite:
1. Java 8 or above
2. MySQL
3. Java IDE


Setup:
1. Download the code and open it using your preference IDE.

2. Go to src/main/java/resources/application.properties to edit the spring data source and change the 'tododb' to a new database or you create a database called 'tododb'
   in your MySQL provided that your MySQL port is 3306.
   - spring.datasource.url = jdbc:mysql://localhost:3306/tododb

3. And go to MySQL and create a table called "todo" as the model has an entity called "todo"

5. And remember to set the password of your MySQL to be able to access the database.

5. Then you may run the application in src/main/java/com.spring.todo.todoAPI/TodoApiApplication and go to localhost:8080/index to access the webpage.
