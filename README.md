
# Recruitment Management System Application
# About the Project
The **Recruitment Management System** is a web-based application designed to streamline the recruitment process for organizations. It provides functionality to manage candidates, job openings, and interview schedules efficiently.

## Key Features
- **Candidate Management**: Add, view, update, and delete candidate profiles.  
- **Job Management**: Create and manage job postings with details like title, description, and requirements.  
- **Interview Scheduling**: Schedule interviews for candidates with specific job openings.  
- **Authentication and Authorization**: Secure the application using role-based access control.  
- **Resume Uploads**: Enable candidates to upload their resumes for job applications.  
- **Responsive UI**: Provide a user-friendly interface using Thymeleaf templates.  

## Objectives
The project aims to:  
- Simplify the recruitment process for HR departments.  
- Provide a centralized platform for managing all recruitment-related data.  
- Ensure secure access to sensitive information using robust authentication mechanisms.

## Technologies Used
- **Backend Framework**: Spring Boot  
- **Frontend Framework**: Thymeleaf  
- **Database**: MySQL  
- **Build Tool**: Maven  

# Creating the Spring Boot Project Using Spring Initializer

## Step 1: Go to Spring Initializer
Visit [Spring Initializer](https://start.spring.io).

## Step 2: Configure the Project Settings

- **Project**: Maven  
- **Language**: Java  
- **Spring Boot Version**: 2.7.15  
- **Group**: `com`  
- **Artifact**: `Recruitment-Management-System`  
- **Name**: Recruitment-Management-System  
- **Description**: A web application for managing recruitment processes.  
- **Packaging**: Jar  
- **Java Version**: 8  

## Step 3: Add Dependencies

- **Spring Web**: For building web applications.  
- **Spring Data JPA**: For interacting with the database.  
- **Spring Security**: For securing the application.  
- **Thymeleaf**: For building the UI templates.  
- **MySQL Driver**: For MySQL database connectivity.  

## Step 4: Download and Extract the Project
- Click the **"Generate"** button to download the project.  
- Extract the ZIP file and open it in your favorite IDE (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code).

## Step 5: Customize the Project Structure
After generating the project, start implementing the directory structure and additional configurations as mentioned in the documentation.

---

## Steps to Run the Application

1. **Navigate to the project directory:**
   ```
   cd Recruitment-Management-System
   ```

2. **Configure MySQL database in `application.properties`:**
   ```properties
   spring.datasource.url = jdbc:mysql://localhost:3306/demo?useSSL=false
   spring.datasource.username = root
   spring.datasource.password = 1234
   ```
3. **Build the project:**
   ```
   mvn clean install
   ```
4. **Run the application:**
   ```
   mvn spring-boot:run
   ```
5. **Access the application:**  
   Visit [http://localhost:8088](http://localhost:8088).
---

## Directory Structure
```
Recruitment-Management-System/
├── config/
│   ├── ErrorHandler.java
│   ├── SecurityConfiguration.java
│   └── WebConfig.java
├── model/
│   ├── Job.java
│   ├── JobApplication.java
│   ├── Resume.java
│   ├── Role.java
│   └── User.java
├── repository/
│   ├── JobApplicationRepository.java
│   ├── JobRepository.java
│   ├── ResumeRepository.java
│   ├── RoleRepository.java
│   └── UserRepository.java
├── service/
│   ├── JobService.java
│   ├── JobServiceImpl.java
│   ├── ResumeService.java
│   ├── UserService.java
│   └── UserServiceImpl.java
├── templates/
│   ├── admin.html
│   ├── job_grid.html
│   └── ...
├── RecruitmentManagementSystemApplication.java
├── pom.xml
├── src/main/resources/application.properties
```
---

## Configuration Files

### `pom.xml`
The `pom.xml` file contains all the project dependencies and build configurations. Below is the content:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.15</version>
        <relativePath/>
    </parent>

    <groupId>com</groupId>
    <artifactId>Recruitment-Management-System</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>Recruitment-Management-System</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Dependencies -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Thymeleaf Security Extras -->
        <dependency>
            <groupId>org.thymeleaf.extras</groupId>
            <artifactId>thymeleaf-extras-springsecurity5</artifactId>
            <version>3.0.4.RELEASE</version>
        </dependency>

        <!-- MySQL Driver -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.33</version>
            <scope>runtime</scope>
        </dependency>

        <!-- Developer Tools -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>

        <!-- Testing Dependencies -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
            <exclusions>
                <exclusion>
                    <groupId>org.junit.vintage</groupId>
                    <artifactId>junit-vintage-engine</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

### `application.properties`
The `application.properties` file contains the application configurations. Below is the content:

```properties
## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url = jdbc:mysql://localhost:3306/demo?useSSL=false
spring.datasource.username = root
spring.datasource.password = 1234

## Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update

logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type=TRACE

# Set the server port
server.port=8088

# File upload configuration
spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB

logging.level.org.thymeleaf=DEBUG
logging.level.org.springframework.web=DEBUG

# Static resources location
spring.resources.static-locations=classpath:/static/, file:src/main/resources/static/uploads/
```

---

## License
This project is licensed under the MIT License.

Feel free to contribute or raise issues for improvements! 🚀
