CREATE SCHEMA libraryupdate;
USE libraryupdate;

-- 1
CREATE TABLE `USER` (
	UserID INT,
    `Name` VARCHAR(255),
    Address VARCHAR(255),
    PhoneNumber VARCHAR(255),
    CONSTRAINT PK_User PRIMARY KEY (UserID)
);

-- 2
CREATE TABLE  READER (
	UserID INT,
    Sub DATETIME,
    CONSTRAINT FK_READER_USER FOREIGN KEY (UserID) REFERENCES `USER`(UserID)
);

-- 3
CREATE TABLE STAFF (
	UserID INT,
    Dept VARCHAR(255),
    Salary DOUBLE,
    CONSTRAINT FK_STAFF_USER FOREIGN KEY (UserID) REFERENCES `USER`(UserID)
);


-- 4
CREATE TABLE CATEGORY(
	CategoryID INT,
    `Name` VARCHAR(255),
    CONSTRAINT PK_CATEGORY PRIMARY KEY (CategoryID)
);

-- 5
CREATE TABLE BOOK (
	BookID INT,
    CategoryID INT,
    `Name` VARCHAR(255),
    Author VARCHAR(255),
    Publication DATETIME,
    `Status` BOOLEAN,
    CONSTRAINT PK_BOOK PRIMARY KEY (BookID),
    CONSTRAINT FK_BOOK_CATEGORY FOREIGN KEY (CategoryID) REFERENCES CATEGORY(CategoryID)
);


-- 6
CREATE TABLE REVIEW (
	ReviewID INT,
    BookID INT,
    UserID INT,
    `Star` INT,
    ReviewTime DATETIME,
    Content TEXT,
    CONSTRAINT PK_REVIEW PRIMARY KEY (ReviewID),
    CONSTRAINT FK_REVIEW_BOOK FOREIGN KEY (BookID) REFERENCES BOOK(BookID),
    CONSTRAINT FK_REVIEW_USER FOREIGN KEY (UserID) REFERENCES `USER`(UserID)
);


-- 7
CREATE TABLE LOAN (
	LoanID INT,
    UserID INT,
	BookID INT,
	Note TEXT,
    CONSTRAINT PK_LOAN PRIMARY KEY (LoanID),
    CONSTRAINT FK_LOAN_USER FOREIGN KEY (UserID) REFERENCES `USER`(UserID),
    CONSTRAINT FK_LOAN_BOOK FOREIGN KEY (BookID) REFERENCES BOOK(BookID)
);


-- 8
CREATE TABLE BORROW (
	LoanID INT,
    ReleaseTime DateTime,
    DueTime DateTime,
    CONSTRAINT FK_BORROW_LOAN FOREIGN KEY (LoanID) REFERENCES LOAN(LoanID)
);


-- 9
CREATE TABLE `RETURN` (
	LoanID INT,
    ReturnTime DATETIME,
    CONSTRAINT FK_RETURN_LOAN FOREIGN KEY (LoanID) REFERENCES LOAN(LoanID)
);


-- 10
CREATE TABLE MANAGERSYSTEM (
	UserID INT,
    UserName VARCHAR(255),
    `Password` VARCHAR(255),
    CONSTRAINT FK_MANAGERSYSTEM_USER FOREIGN KEY (UserID) REFERENCES `USER`(UserID)
);

-- 11
CREATE TABLE ISSUE(
	IssueID INT,
    BookID INT,
    IssueStatus BOOL,
    Note TEXT,
    CONSTRAINT PK_ISSUE PRIMARY KEY (IssueID),
    CONSTRAINT FK_ISSUE_BOOK FOREIGN KEY (BookID) REFERENCES BOOK(BookID)
) 


