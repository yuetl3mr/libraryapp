# Library Management Application

## Introduction
The **Library Management Application** is a Java-based software designed to optimize the management processes of a library. It focuses on key aspects such as book catalog management, loan and return tracking, quick information search, and providing comprehensive statistics on the library's status. By integrating advanced technology, this application aims to improve work efficiency and offer a seamless and convenient experience for both administrators and readers.
![Login](https://imgur.com/a/cuOgmFY)
![Statistical](https://imgur.com/a/7VzDDRQ)
![Book Manage](https://imgur.com/a/Dc8T6mT)
## Features
- **Book Catalog Management:** Manage the library's book collection, including adding, editing, and deleting book records.
- **Loan and Return Tracking:** Track the borrowing and returning of books, ensuring accurate records of book availability.
- **Quick Information Search:** Allow users to quickly search for books, authors, and other relevant information.
- **Statistics and Reports:** Generate reports and statistics on library operations, such as the most borrowed books and overdue books.
- **User Management:** Manage reader information, including registration, membership details, and borrowing history.

## Requirements
- **Java Development Kit (JDK):** Version 11 or higher
- **Database:** MySQL 
- **Build Tool:** Maven

## Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/library-management-java.git
    ```
2. Navigate to the project directory:
    ```bash
    cd library-management-java
    ```
3. Set up the database:
    - Create a database named `library_db`.
    - Run the SQL scripts located in the `src/main/sqlFinal/` directory to create the necessary tables.
4. Configure the database connection in `application.properties` or `application.yml`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/library_db
    spring.datasource.username=your_db_username
    spring.datasource.password=your_db_password
    ```
5. Build the project using Maven or Gradle:
    ```bash
    mvn clean install
    ```
6. Run the application:
    ```bash
    java -jar target/library-management-1.0.jar
    ```

## Usage
1. Launch the application from the command line or using your favorite IDE.
2. Log in as an administrator to manage the library's catalog, track loans and returns, and generate reports.
3. Readers can search for books and view their borrowing history.

## Technologies Used
- **Backend:** Java
- **GUI:** Java Swing
- **Database:** MySQL
- **Build Tool:** Maven
- **Others:** Hibernate for ORM

## Contribution
We welcome contributions! If you'd like to contribute to this project, please fork the repository and create a pull request with your changes. Be sure to follow the coding standards and include detailed commit messages.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
