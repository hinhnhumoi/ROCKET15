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
																			(	3	,	N'k??? to??n'	),
																			(	4	,	N'nh??n s???'	),
																			(	5	,	N'k?? thu???t'	);
INSERT INTO Position  (positionID,positionName)		VALUES 					(	1	,	N'Gi??m ?????c'),
																			(	2	,	N'tr?????ng ph??ng'	),
																			(	3	,	N'ph?? ph??ng'	),
																			(	4	,	N'nh??n vi??n'	),
																			(	5	,	N'c???ng t??c vi??n'	);
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
INSERT INTO TypeQuestion  VALUES 											(1,N'lo???i 1'),
																			(2,N'lo???i 2'),
                                                                            (3,N'lo???i 3'),
                                                                            (4,N'lo???i 4'),
                                                                            (5,N'lo???i 5');
INSERT INTO CategoryQuestion  VALUES										(1,N'To??n'),
																			(2,N'V??n'),
																			(3,N'Anh'),
                                                                            (4,N'L??'),
                                                                            (5,N'H??a');
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
INSERT INTO exam  VALUES 													(1,211,N'Gi???a k?? 1',1,'',1,'2021-6-15'),
																			(2,212,N'Gi???a k?? 2',2,'',2,'2021-6-15'),
                                                                            (3,213,N'Gi???a k?? 3',3,'',3,'2021-6-15'),
                                                                            (4,214,N'Gi???a k?? 4',4,'',4,'2021-6-15'),
                                                                            (5,215,N'Gi???a k?? 5',5,'',5,'2021-6-15');
INSERT INTO ExamQuestion VALUES 											(1,1),
																			(2,2),
                                                                            (3,3),
                                                                            (4,4),
                                                                            (5,5);
                                                                            
select * from department;
select departmentID from department where departmentName='sales';
select accountID,username,fullname, char_length(fullname) as Name_lenght from `Account`  order by Name_lenght DESC  limit 1;
select accountID,username,fullname, char_length(fullname) as Name_lenght from `Account` where departmentID=3  order by Name_lenght DESC  limit 1; 
select groupName,createDate from `Group` where createDate>'2019-12-20';
select questionID, count(*) as Answer_numb from `answer` group by questionID having Answer_numb>=4;
select `code`, duration,createDate from Exam where createDate>'2019-12-20' and duration>='00:04:00';
select groupName,createDate from `group` order by createDate desc limit 5;
select departmentID,count(*) as total, group_concat(fullname) from `account` where departmentID=2;
select fullname from `account` where fullname like 'D%o';
delete from exam where createDate<'2019-12-20';
delete from question where content like 'c??u h???i%';
update `Account` set fullname=N'Nguy???n B?? L???c' and email='loc.nguyenba@vti.com.vn' where accountID=5;
