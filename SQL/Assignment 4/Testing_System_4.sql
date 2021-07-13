drop database if exists CongtyABC;
create database CongtyABC;

use CongtyABC;

CREATE TABLE Department (
    departmentID INT auto_increment not null PRIMARY KEY,
    departmentName VARCHAR(20) 	NOT NULL
);

CREATE TABLE `Position` (
    positionID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    positionName VARCHAR(30) NOT NULL
);

CREATE TABLE `Account` (
    accountID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    email VARCHAR(30) NOT NULL,
    username VARCHAR(30) NOT NULL,
    fullname VARCHAR(30) NOT NULL,
    departmentID INT,
    positionID INT,
    createDate DATE,
    FOREIGN KEY (departmentID) REFERENCES  Department(departmentID),
    FOREIGN KEY (positionID) REFERENCES  `Position`(positionID)
);

CREATE TABLE `Group` (
    groupID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    groupName VARCHAR(30) NOT NULL,
    creatorID INT NOT NULL,
    createDate DATE
);

CREATE TABLE GroupAccount (
    groupID INT,
    accountID INT,
    joinDate DATE,
    PRIMARY KEY (groupID,accountID),
    FOREIGN KEY (accountID) REFERENCES 	`Account`(accountID),
    FOREIGN KEY (groupID) REFERENCES 	`Group`(groupID)
);

CREATE TABLE TypeQuestion (
    typeID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    typeName VARCHAR(30) NOT NULL
);

CREATE TABLE CategoryQuestion (
    categoryID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    categoryName VARCHAR(30) NOT NULL
);

CREATE TABLE `Question` (
    questionID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    content TEXT NOT NULL,
    categoryID INT,
    typeID INT,
    creatorID INT NOT NULL,
    createDate DATE,
    FOREIGN KEY (typeID) REFERENCES TypeQuestion(typeID),
    FOREIGN KEY (categoryID) REFERENCES CategoryQuestion(categoryID)
);

CREATE TABLE `answer` (
    answerID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    content TEXT NOT NULL,
    questionID INT,
    isCorrect BOOLEAN,
    FOREIGN KEY (questionID) REFERENCES `Question`(questionID)
);

CREATE TABLE Exam (
    examID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `code` INT NOT NULL,
    title VARCHAR(30) NOT NULL,
    categoryID INT,
    duration TIME DEFAULT ('00:05:00'),
    creatorID INT NOT NULL,
    createDate DATE,
    FOREIGN KEY (categoryID) REFERENCES CategoryQuestion(categoryID)
);

CREATE TABLE ExamQuestion (
    examID INT ,
    questionID INT,
    PRIMARY KEY (examID,questionID),
    FOREIGN KEY (questionID) REFERENCES `Question`(questionID),
    FOREIGN KEY (examID) REFERENCES Exam(examID)
);
-- INSERT DATA
INSERT INTO Department (departmentID,departmentName)	VALUES 				(	1	,	N'marketing'	),
																			(	2	,	N'sales'	),
																			(	3	,	N'kế toán'	),
																			(	4	,	N'nhân sự'	),
																			(	5	,	N'kĩ thuật'	);
INSERT INTO Position  (positionID,positionName)		VALUES 					(	1	,	N'Giám đốc'),
																			(	2	,	N'trưởng phòng'	),
																			(	3	,	N'phó phòng'	),
																			(	4	,	N'nhân viên'	),
																			(	5	,	N'cộng tác viên'	);
INSERT INTO `account`  								values 					(1, '1@gmail.com','one','nguyen van A',1,1,'2021-06-20'),
																			(2, '2@gmail.com','two','nguyen van B',2,2,'2021-06-20'),
                                                                            (3, '3@gmail.com','three','nguyen van C',3,3,'2021-06-20'),
                                                                            (4, '4@gmail.com','four','nguyen van D',4,4,'2021-06-20'),
                                                                            (5, '5@gmail.com','five','nguyen van E',5,5,'2021-06-20');
INSERT INTO `Group`									VALUES					(1, 'group1',1,'2021-6-28'),
																			(2, 'group2',2,'2021-6-28'),
                                                                            (3, 'group3',3,'2021-6-28'),
                                                                            (4, 'group4',4,'2021-6-28'),
                                                                            (5, 'group5',5,'2021-6-28');
INSERT INTO  GroupAccount 	values 											(1,1,'2021-6-23'),
																			(2,2,'2021-6-23'),
                                                                            (3,3,'2021-6-23'),
                                                                            (4,4,'2021-6-23'),
                                                                            (5,5,'2021-6-23');
INSERT INTO TypeQuestion  VALUES 											(1,N'loại 1'),
																			(2,N'loại 2'),
                                                                            (3,N'loại 3'),
                                                                            (4,N'loại 4'),
                                                                            (5,N'loại 5');
INSERT INTO CategoryQuestion  VALUES										(1,N'Toán'),
																			(2,N'Văn'),
																			(3,N'Anh'),
                                                                            (4,N'Lý'),
                                                                            (5,N'Hóa');
INSERT INTO `Question` values 												(1,N'content1',1,1,1,'2021-6-26'),
																			(2,N'content2',2,2,2,'2021-6-26'),
                                                                            (3,N'content3',3,3,3,'2021-6-26'),
                                                                            (4,N'content4',4,4,4,'2021-6-26'),
                                                                            (5,N'content5',5,5,5,'2021-6-26');
INSERT INTO `answer` VALUES													(1,'content1',1,1),
																			(2,'content2',2,2),
                                                                            (3,'content3',3,3),
                                                                            (4,'content4',4,4),
                                                                            (5,'content5',5,5);
INSERT INTO exam  VALUES 													(1,211,N'Giữa kì 1',1,'',1,'2021-6-15'),
																			(2,212,N'Giữa kì 2',2,'',2,'2021-6-15'),
                                                                            (3,213,N'Giữa kì 3',3,'',3,'2021-6-15'),
                                                                            (4,214,N'Giữa kì 4',4,'',4,'2021-6-15'),
                                                                            (5,215,N'Giữa kì 5',5,'',5,'2021-6-15');
INSERT INTO ExamQuestion VALUES 											(1,1),
																			(2,2),
                                                                            (3,3),
                                                                            (4,4),
                                                                            (5,5);
 
 
SELECT 
    b.username, b.fullname, a.departmentName
FROM
    Department AS a
        RIGHT JOIN
    `Account` AS b ON a.departmentID = b.departmentID;
    ----
SELECT 
    username, fullname, departmentName
FROM
    Department AS a
        LEFT JOIN
    `Account` AS b ON a.departmentID = b.departmentID
WHERE
    departmentID = 2
        AND createDate > '2010-12-20';
----
SELECT 
    a.username, a.fullname, b.positionName
FROM
    `Account` AS a
        INNER JOIN
    `Position` AS b ON a.positionID = b.positionID
WHERE
    positionName = 'giám đốc';
----
SELECT 
    a.departmentName, COUNT(b.accountID)
FROM
    Department AS a
        LEFT JOIN
    `Account` AS b ON a.departmentID = b.departmentID
GROUP BY a.departmentName
HAVING COUNT(b.accountID)>0;
---- cau 5 ----
SELECT 
    a.questionID, b.examID, COUNT(b.examID)
FROM
    question AS a
        INNER JOIN
    ExamQuestion AS b ON a.questionID = b.questionID
GROUP BY a.questionID
ORDER BY COUNT(b.examID) DESC
LIMIT 1;
use CongtyABC;


----- UNION
select a.username,a.fullname,b.groupID from `Account` as a inner join GroupAccount as b on a.accountID=b.accountID where b.groupID=1;
select a.username,a.fullname,b.groupID from `Account` as a inner join GroupAccount as b on a.accountID=b.accountID where b.groupID=2;

SELECT 
    a.username, a.fullname, b.groupID
FROM
    `Account` AS a
        INNER JOIN
    GroupAccount AS b ON a.accountID = b.accountID
WHERE
    b.groupID = 1 
UNION SELECT
    a.username, a.fullname, b.groupID
FROM
    `Account` AS a
        INNER JOIN
    GroupAccount AS b ON a.accountID = b.accountID
WHERE
    b.groupID = 2;


-- cau 11:
 SELECT ;
-- cau 18
select b.groupID,count(b.accountID),b.groupName from `Account` as a inner join GroupAccount as b on a.accountID=b.accountID group by b.groupID having count(b.accountID)>0;
select b.groupID,count(b.accountID),b.groupName from `Account` as a inner join GroupAccount as b on a.accountID=b.accountID group by b.groupID having count(b.accountID)<7;
SELECT 
    b.groupID, COUNT(b.accountID),b.groupName
FROM
    `Account` AS a
        INNER JOIN
    GroupAccount AS b ON a.accountID = b.accountID
GROUP BY b.groupID
HAVING COUNT(b.accountID) > 5 
UNION 
SELECT 
    b.groupID, COUNT(b.accountID),b.groupName
FROM
    `Account` AS a
        INNER JOIN
    GroupAccount AS b ON a.accountID = b.accountID
GROUP BY b.groupID
HAVING COUNT(b.accountID) < 7;