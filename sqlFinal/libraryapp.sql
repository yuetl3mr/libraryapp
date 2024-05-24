CREATE DATABASE libraryapp;
GO

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
	bAuthor varchar(255),
	bPublication date
);

CREATE TABLE LOAN(
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

