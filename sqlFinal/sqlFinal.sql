CREATE SCHEMA libraryupdatelate;
USE libraryupdatelate;

-- 1
CREATE TABLE `USER` (
	userId INT,
    `name` VARCHAR(255),
    address VARCHAR(255),
    phoneNumber VARCHAR(255),
    CONSTRAINT PK_User PRIMARY KEY (userID)
);

CREATE TABLE MANAGERSYSTEM (
	userId INT,
    userName VARCHAR(255),
    `password` VARCHAR(255),
    CONSTRAINT FK_MANAGERSYSTEM_USER FOREIGN KEY (userID) REFERENCES `USER`(userId)
);

-- DROP TABLE MANAGERSYSTEM;


-- 2
CREATE TABLE READER (
	userId INT,
    sub DATETIME,
    CONSTRAINT FK_READER_USER FOREIGN KEY (userId) REFERENCES `USER`(userId)
);

-- 3
CREATE TABLE STAFF (
	userId INT,
    dept VARCHAR(255),
    salary DOUBLE,
    CONSTRAINT FK_STAFF_USER FOREIGN KEY (userId) REFERENCES `USER`(userId)
);


-- 4
CREATE TABLE CATEGORY(
	categoryId INT,
    `name` VARCHAR(255),
    CONSTRAINT PK_CATEGORY PRIMARY KEY (categoryId)
);

-- 5
CREATE TABLE BOOK (
	bookId INT,
    categoryId INT,
    `name` VARCHAR(255),
    author VARCHAR(255),
    publication DATETIME,
    `status` BOOLEAN,
    CONSTRAINT PK_BOOK PRIMARY KEY (bookId),
    CONSTRAINT FK_BOOK_CATEGORY FOREIGN KEY (categoryId) REFERENCES CATEGORY(categoryId)
);


-- 6
CREATE TABLE REVIEW (
	reviewId INT,
    bookId INT,
    userId INT,
    `star` INT,
    reviewTime DATETIME,
    content TEXT,
    CONSTRAINT PK_REVIEW PRIMARY KEY (reviewId),
    CONSTRAINT FK_REVIEW_BOOK FOREIGN KEY (bookId) REFERENCES BOOK(bookId),
    CONSTRAINT FK_REVIEW_USER FOREIGN KEY (userId) REFERENCES READER(userId)
);


-- 7
CREATE TABLE LOAN (
	loanId INT,
	note TEXT,
    `status` BOOLEAN,
    CONSTRAINT PK_LOAN PRIMARY KEY (loanId)
);


-- 8
CREATE TABLE BORROW (
	loanId INT,
    userId INT,
    bookId INT,
    releaseTime DateTime,
    dueTime DateTime,
    CONSTRAINT FK_BORROW_READER FOREIGN KEY (userId) REFERENCES READER(userId),
    CONSTRAINT FK_BORROW_LOAN FOREIGN KEY (loanId) REFERENCES LOAN(loanId),
    CONSTRAINT FK_BORROW_BOOK FOREIGN KEY (bookId) REFERENCES BOOK(bookId)
);

-- DROP TABLE BORROW;
-- 9
CREATE TABLE `RETURN` (
	loanId INT,
    userId INT,
    bookId INT,
    returnTime DATETIME,
    CONSTRAINT FK_RETURN_READER FOREIGN KEY (userId) REFERENCES READER(userId),
    CONSTRAINT FK_RETURN_LOAN FOREIGN KEY (loanId) REFERENCES LOAN(loanId),
    CONSTRAINT FK_RETURN_BOOK FOREIGN KEY (bookId) REFERENCES BOOK(bookId)
);


-- 10


-- 11
CREATE TABLE ISSUE(
	issueId INT,
    bookId INT,
    userId INT,
    issueStatus BOOLEAN,
    note TEXT,
    CONSTRAINT PK_ISSUE PRIMARY KEY (issueID),
    CONSTRAINT FK_ISSUE_BOOK FOREIGN KEY (bookId) REFERENCES BOOK(bookId),
    CONSTRAINT FK_ISSUE_READER FOREIGN KEY (userId) REFERENCES READER(userId)
);

-- INSERT INTO `USER` (UserID, `Name`, Address, PhoneNumber) VALUES
-- (1, 'Nguyễn Đức Thanh Phong', 'Hà Giang', '123-456-7890'),
-- (2, 'Nguyễn Văn Vinh', 'Đắk Nông', '234-567-8901'),
-- (3, 'Lê Tiến Duy', 'Thừa Thiên Huế', '345-678-9012'),
-- (4, 'Lê Chính Quang', 'Bình Dương', '456-789-0123'),
-- (5, 'Nguyễn Khánh Duy', 'Bạc Liêu', '567-890-1234'),
-- (6, 'Hà Minh Hiếu', 'Khánh Hòa', '678-901-2345'),
-- (7, 'Lê Trung Chính', 'Hà Nam', '789-012-3456'),
-- (8, 'Ngô Minh Hoàng', 'Bắc Kạn', '890-123-4567'),
-- (9, 'Mai Phước Phong', 'Hà Nội', '901-234-5678'),
-- (10, 'Lê Văn Thịnh', 'Bình Định', '012-345-6789'),
-- (11, 'Nguyễn Văn Yên', 'Thái Bình', '123-456-7890'),
-- (12, 'Nguyễn Văn Yên', 'Hồ Chí Minh', '234-567-8901'),
-- (13, 'Phạm Minh Quân', 'Đồng Tháp', '345-678-9012'),
-- (14, 'Võ Quang Thạch', 'Nghệ An', '456-789-0123'),
-- (15, 'Nguyễn Trung Kiên', 'Bến Tre', '567-890-1234'),
-- (16, 'Trần Hoàng Thảo Ly', 'Bà Rịa - Vũng Tàu', '678-901-2345'),
-- (17, 'Nguyễn Thị Thu Trang', 'Cà Mau', '789-012-3456'),
-- (18, 'Nguyễn Thị Thu Trang', 'Ninh Thuận', '890-123-4567'),
-- (19, 'Châu Ngọc Thịnh', 'Hải Dương', '901-234-5678'),
-- (20, 'Nguyễn Trường Thạnh', 'Nam Định', '012-345-6789');

-- INSERT INTO READER (UserID, Sub) VALUES
-- (1, '2024-03-01 08:00:00'),
-- (2, '2024-03-02 09:00:00'),
-- (3, '2024-03-03 10:00:00'),
-- (4, '2024-03-04 11:00:00'),
-- (5, '2024-03-05 12:00:00'),
-- (6, '2024-03-06 13:00:00'),
-- (7, '2024-03-07 14:00:00'),
-- (8, '2024-03-08 15:00:00'),
-- (9, '2024-03-09 16:00:00'),
-- (10, '2024-03-10 17:00:00'),
-- (11, '2024-03-11 18:00:00'),
-- (12, '2024-03-12 19:00:00'),
-- (13, '2024-03-13 20:00:00'),
-- (14, '2024-03-14 21:00:00'),
-- (15, '2024-03-15 22:00:00'),
-- (16, '2024-03-16 23:00:00');
-- SELECT * FROM `READER`;
-- UPDATE READER
-- SET Sub = '2024-06-01'
-- WHERE UserID > 0;

-- INSERT INTO STAFF (UserID, Dept, Salary) VALUES
-- (17, 'trưởng phòng', 7000000),
-- (18, 'nhân viên', 5000000),
-- (19, 'nhân viên', 5000000),
-- (20, 'nhân viên', 5000000);

-- INSERT INTO MANAGERSYSTEM (UserID, UserName, Password) VALUES
-- (1, 'Pitapatriot', 'IomPQa86'),
-- (2, 'Glamorc', 'xrR6GY0p'),
-- (3, 'Cyborne', '2Ivs2UkJ'),
-- (4, 'Komodozer', 'Vdg2N3gW'),
-- (5, 'BreakfastMonster', 'oUY9b2zH'),
-- (6, 'WittyBlizzard', 'dQeS24vW'),
-- (7, 'MiniAntelope', '90lPsTUv'),
-- (8, 'BitterPeafowl', 'c85OcEQp'),
-- (9, 'AwesomeBlackberry', 'ZwTq9U0m'),
-- (10, 'FlameButterfly', 'pX5qsA5G'),
-- (11, 'Roguerrilla', 'Db0VY5qd'),
-- (12, 'Warachnid', '0kZh1LJu'),
-- (13, 'Sailorc', '3nT4TnoB'),
-- (14, 'Penguinee', '5jCsHvL0'),
-- (15, 'FluffyLarva', '68KNffVs'),
-- (16, 'CoolManatee', 'vyF99ZKd'),
-- (17, 'MagmaDoggy', 'raV9BY1t'),
-- (18, 'RapidBruiser', 'yJqB7J4t'),
-- (19, 'ShadowUrchin', 'zKx6Bl5I'),
-- (20, 'FarmYew', 'cI0qOBd9');

-- INSERT INTO CATEGORY (CategoryID, `Name`)
-- VALUES (1, 'Fantasy'),
--        (2, 'Science Fiction'),
--        (3, 'Romance'),
--        (4, 'Fiction'),
--        (5, 'Magical Realism'),
--        (6, 'Novel'),
--        (7, 'Gothic Fiction'),
--        (8, 'Dystopian Fiction'),
--        (9, 'Coming-of-age'),
--        (10, 'Satirical Fiction'),
--        (11, 'Modernist Literature'),
--        (12, 'Allegory'),
--        (13, 'Political Satire'),
--        (14, 'Historical Fiction'),
--        (15, 'Novella');


-- INSERT INTO BOOK (BookID, `Name`, Author, CategoryID, Publication, `Status`)
-- 	VALUES  (1, 'The Lord of the Rings', 'J. R. R. Tolkien', 1 , '1954-07-29', true),
-- 			(2, 'The Hitchhiker\'s Guide to the Galaxy', 'Douglas Adams', 2 , '1979-10-12', true),
-- 			(3, 'Pride and Prejudice', 'Jane Austen', 3 , '1813-01-28', false),
-- 			(4, 'To Kill a Mockingbird', 'Harper Lee', 4 , '1960-07-11', True),
-- 			(5, 'One Hundred Years of Solitude', 'Gabriel García Márquez', 5 , '1967-05-06', True),
-- 			(6, 'The Great Gatsby', 'F. Scott Fitzgerald', 6 , '1925-04-10', True),
-- 			(7, 'Frankenstein', 'Mary Shelley', 7 , '1818-02-03', True),
-- 			(8, 'Dune', 'Frank Herbert', 2 , '1965-05-06', True),
-- 			(9,  '1984','George Orwell', 8, '1949-05-06', True),
-- 			(10, 'The Catcher in the Rye', 'J. D. Salinger', 9 , '1951-05-06', True),
-- 			(11, 'The Adventures of Huckleberry Finn', 'Mark Twain', 10 , '1884-05-06', True),
-- 			(12, 'Ulysses', 'James Joyce', 11 , '1922-05-06', True),
-- 			(13, 'The Lord of the Flies', 'William Golding', 12 , '1954-05-14', True),
-- 			(14, 'Animal Farm', 'George Orwell', 13 , '1945-08-06', True),
-- 			(15, 'The Handmaid\'s Tale', 'Margaret Atwood', 8 , '1985-05-06', True),
-- 			(16, 'The Book Thief', 'Markus Zusak', 14 , '2005-09-20', True),
-- 			(17, 'Moby Dick', 'Herman Melville', 6 , '1851-05-06', True),
-- 			(18, 'The Metamorphosis', 'Franz Kafka', 15 , '1915-10-15', True),
-- 			(19, 'In Search of Lost Time', 'Marcel Proust', 6 , '1913-05-06', True),
-- 			(20, 'Crime and Punishment', 'Fyodor Dostoevsky', 6 , '1866-05-06', True);

-- INSERT INTO REVIEW (ReviewID, BookID, UserID, Star, ReviewTime, Content)
-- VALUES  (1, 1, 17, 5, '2024-03-15 10:00:00', 'This is an amazing book! I loved it so much!'),
-- 		(2, 2, 18, 4, '2024-03-16 12:00:00', 'A fun and imaginative story!'),
--         (3, 5, 15, 4, '2024-03-17 11:00:00', 'A beautiful and magical story.'),
--         (4, 6, 16, 3, '2024-03-18 17:00:00', 'Well-written, but the ending felt rushed.'),	
--         (5, 7, 17, 5, '2024-03-19 09:00:00', 'A timeless classic that everyone should read!'),
--         (6, 8, 18, 4, '2024-03-20 14:00:00', 'An interesting world-building concept, but the plot dragged a bit.'),
--         (7, 9, 19, 5, '2024-03-21 20:00:00', 'A powerful and thought-provoking dystopian novel.'),
-- 		(8, 10, 20, 4, '2024-03-22 08:00:00', 'Salinger captures the angst of adolescence perfectly.'),
--         (9, 11, 13, 2, '2024-03-14 20:00:00', 'The plot felt underdeveloped.'),
--         (10, 12, 14, 5, '2024-03-11 16:00:00', 'A masterpiece of modern literature!'),
--         (11, 14, 13, 4, '2024-03-23 13:00:00', 'A clever allegory with a surprising twist.'),
--         (12, 15, 14, 5, '2024-03-24 19:00:00', 'A captivating story that will stay with you long after you finish reading.'),
--         (13, 17, 19, 3, '2024-03-10 15:00:00', 'A bit too long, but a classic nonetheless.'),
--         (14, 18, 20, 5, '2024-03-12 18:00:00', 'A thought-provoking and well-written novella.'),
-- 		(15, 19, 15, 3, '2024-03-25 07:00:00', 'Beautifully written, but slow-paced at times.'),
--         (16, 20, 16, 5, '2024-03-26 12:00:00', 'Dostoevsky delivers a powerful exploration of guilt and punishment.');

-- INSERT INTO LOAN (LoanID, UserID, BookID, Note) VALUES
-- (1, 17, 15, 'Loan for "The Handmaid''s Tale" by Margaret Atwood'),
-- (2, 18, 16, 'Loan for "The Book Thief" by Markus Zusak'),
-- (3, 19, 17, 'Loan for "Moby Dick" by Herman Melville'),
-- (4, 20, 18, 'Loan for "The Metamorphosis" by Franz Kafka'),
-- (5, 1, 19, 'Loan for "In Search of Lost Time" by Marcel Proust'),
-- (6, 2, 20, 'Loan for "Crime and Punishment" by Fyodor Dostoevsky'),
-- (7, 3, 1, 'Loan for "The Lord of the Rings" by J. R. R. Tolkien'),
-- (8, 4, 2, 'Loan for "The Hitchhiker''s Guide to the Galaxy" by Douglas Adams'),
-- (9, 5, 3, 'Loan for "Pride and Prejudice" by Jane Austen'),
-- (10, 6, 4, 'Loan for "To Kill a Mockingbird" by Harper Lee'),
-- (11, 13, 11, 'Loan for "The Adventures of Huckleberry Finn" by Mark Twain'),
-- (12, 14, 12, 'Loan for "Ulysses" by James Joyce'),
-- (13, 15, 13, 'Loan for "The Lord of the Flies" by William Golding'),
-- (14, 16, 14, 'Loan for "Animal Farm" by George Orwell');

-- INSERT INTO BORROW (LoanID, ReleaseTime, DueTime) VALUES
-- (1, '2024-03-01 08:00:00', '2024-03-08 08:00:00'),
-- (2, '2024-03-02 09:00:00', '2024-03-16 09:00:00'),
-- (3, '2024-03-03 10:00:00', '2024-03-10 10:00:00'),
-- (4, '2024-03-04 11:00:00', '2024-03-18 11:00:00'),
-- (5, '2024-03-05 12:00:00', '2024-03-12 12:00:00'),
-- (6, '2024-03-06 13:00:00', '2024-03-20 13:00:00'),
-- (7, '2024-03-07 14:00:00', '2024-03-14 14:00:00'),
-- (8, '2024-03-08 15:00:00', '2024-03-22 15:00:00'),
-- (9, '2024-03-09 16:00:00', '2024-03-16 16:00:00'),
-- (10, '2024-03-10 17:00:00', '2024-03-24 17:00:00'),
-- (11, '2024-03-11 18:00:00', '2024-03-18 18:00:00'),
-- (12, '2024-03-12 19:00:00', '2024-03-26 19:00:00'),
-- (13, '2024-03-13 20:00:00', '2024-03-20 20:00:00'),
-- (14, '2024-03-14 21:00:00', '2024-03-28 21:00:00');


-- INSERT INTO `RETURN` (LoanID, ReturnTime) VALUES
-- (1, '2024-03-07 08:00:00'),
-- (2, '2024-03-15 09:00:00'),
-- (3, '2024-03-08 10:00:00'),
-- (4, '2024-03-16 11:00:00'),
-- (5, '2024-03-11 12:00:00'),
-- (6, '2024-03-18 13:00:00'),
-- (7, '2024-03-14 14:00:00'),
-- (8, '2024-03-20 15:00:00'),
-- (9, '2024-03-15 16:00:00'),
-- (10, '2024-03-23 17:00:00'),
-- (11, '2024-03-17 18:00:00'),
-- (12, '2024-03-25 19:00:00'),
-- (13, '2024-03-19 20:00:00'),
-- (14, '2024-03-27 21:00:00');

-- INSERT INTO ISSUE (IssueID ,BookID, IssueStatus, Note)
-- VALUES  (1, 3, FALSE, 'Book cover is ripped and pages are dog-eared.'),
-- 		(2, 10, FALSE, 'Book cannot be located on shelf.'),
-- 		(3, 14, FALSE, 'Book barcode is damaged and unscannable.'),
--         (4, 18, FALSE, 'Several pages are water damaged and illegible.'),
--         (5, 19, FALSE, 'Book binding is coming apart and needs repair.');

-- SELECT * FROM `USER`;
-- SELECT * FROM READER;
-- SELECT * FROM STAFF;
-- SELECT * FROM BOOK;
-- SELECT * FROM REVIEW;
-- SELECT * FROM LOAN;
-- SELECT * FROM BORROW;
-- SELECT * FROM `RETURN`;
-- SELECT * FROM MANAGERSYSTEM ;
-- SELECT * FROM ISSUE;
-- SELECT * FROM category;



-- DELETE FROM ISSUE;
-- DELETE FROM `RETURN`;
-- DELETE FROM BORROW;
-- DELETE FROM LOAN;
-- DELETE FROM REVIEW;
-- DELETE FROM BOOK;
-- DELETE FROM category;
-- DELETE FROM MANAGERSYSTEM ;
-- DELETE FROM STAFF;
-- DELETE FROM READER;
-- DELETE FROM `USER`;

