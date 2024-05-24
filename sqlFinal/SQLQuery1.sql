CREATE DATABASE libraryapp;
GO

USE libraryapp;
--USE master;
--GO
--ALTER DATABASE libraryapp SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
--GO
--DROP DATABASE libraryapp;

CREATE TABLE Users(
	UserID int PRIMARY KEY,
	uName varchar(255),
	Addrs varchar(255),
	eMail varchar(255),
	UserLogin varchar(25) NOT NULL,
	UserPassword varchar(25) NOT NULL,
	uRole bit DEFAULT 0
);


CREATE TABLE Books(
	BookID int PRIMARY KEY,
	bName varchar(255),
	CategoryID int,
	bAuthor varchar(255),
	bPublication date
	CONSTRAINT fk_books_cate
	FOREIGN KEY (CategoryID)
	REFERENCES Category(CategoryID),
);

CREATE TABLE Category(
	CategoryID int PRIMARY KEY,
	cName varchar(255)
)

CREATE TABLE Loans(
	LoanID int PRIMARY KEY,
	BookID int NOT NULL,
	UserID int NOT NULL,
	BorrowTime date,
	DueTime date,
	ReturnTime date,
	CONSTRAINT fk_loan_user
	FOREIGN KEY (UserID)
	REFERENCES Users(UserID),
	CONSTRAINT fk_loan_books
	FOREIGN KEY (BookID)
	REFERENCES Books(BookID)
)

INSERT INTO Category(CategoryID, cName)
VALUES
    (1, 'Fiction'),
    (2, 'Non-fiction'),
    (3, 'Science Fiction'),
    (4, 'Fantasy'),
    (5, 'Mystery'),
    (6, 'Thriller'),
    (7, 'Biography'),
    (8, 'History'),
    (9, 'Self-help'),
    (10, 'Romance');

-- Thêm dữ liệu vào bảng Books
INSERT INTO Books (BookID, bName, CategoryID, bAuthor, bPublication)
VALUES
    (1, 'To Kill a Mockingbird', 1, 'Harper Lee', '1960-07-11'),
    (2, '1984', 1, 'George Orwell', '1949-06-08'),
    (3, 'Pride and Prejudice', 1, 'Jane Austen', '1813-01-28'),
    (4, 'The Great Gatsby', 1, 'F. Scott Fitzgerald', '1925-04-10'),
    (5, 'Harry Potter and the Philosopher''s Stone', 4, 'J.K. Rowling', '1997-06-26'),
    (6, 'The Catcher in the Rye', 1, 'J.D. Salinger', '1951-07-16'),
    (7, 'The Lord of the Rings', 4, 'J.R.R. Tolkien', '1954-07-29'),
    (8, 'The Hobbit', 4, 'J.R.R. Tolkien', '1937-09-21'),
    (9, 'Animal Farm', 1, 'George Orwell', '1945-08-17'),
    (10, 'The Chronicles of Narnia', 4, 'C.S. Lewis', '1950-10-16'),
    (11, 'The Da Vinci Code', 6, 'Dan Brown', '2003-03-18'),
    (12, 'The Alchemist', 9, 'Paulo Coelho', '1988-09-01'),
    (13, 'A Tale of Two Cities', 1, 'Charles Dickens', '1859-11-26'),
    (14, 'The Hunger Games', 4, 'Suzanne Collins', '2008-09-14'),
    (15, 'The Diary of a Young Girl', 7, 'Anne Frank', '1947-06-25'),
    (16, 'Gone with the Wind', 1, 'Margaret Mitchell', '1936-06-30');

