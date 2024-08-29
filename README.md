## Introduction
The **Library Management Application** is a Java-based software designed to optimize the management processes of a library. It focuses on key aspects such as book catalog management, loan and return tracking, quick information search, and providing comprehensive statistics on the library's status. By integrating advanced technology, this application aims to improve work efficiency and offer a seamless and convenient experience for both administrators and readers.

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
4. Configure the database connection in `hibernate.cfg.xml`:
    ```properties
        <property name="connection.url">jdbc:mysql://localhost:3306/lbr</property>
		<property name="connection.username">username</property>
		<property name="connection.password">password</property>
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
![Login](https://github.com/user-attachments/assets/6d104c45-dbda-4293-8213-4f51641f1c4c)
![Statistical](https://github.com/user-attachments/assets/a74d82e1-2bb2-4b2c-bc29-d10ddc9c314b)
![Book Manage](https://github.com/user-attachments/assets/bffc329d-f6a8-4492-9a54-7944c6ee2334)

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
