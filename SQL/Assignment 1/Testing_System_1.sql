drop database if exists CongtyABC;
create database CongtyABC;

use CongtyABC;

CREATE TABLE Department (
    departmentID INT,
    departmentName VARCHAR(20)
);

CREATE TABLE Position (
    positionID INT,
    positionName VARCHAR(30)
);

CREATE TABLE Account (
    accountID INT,
    email VARCHAR(30),
    username VARCHAR(30),
    fullname VARCHAR(30),
    departmentID INT,
    positionID INT,
    createDate DATE
);

CREATE TABLE `Group` (
    groupID INT,
    groupName VARCHAR(30),
    creatorID INT,
    createDate DATE
);

CREATE TABLE GroupAccount (
    groupID INT,
    accountID INT,
    joinDate DATE
);

CREATE TABLE TypeQuestion (
    typeID INT,
    typeName VARCHAR(30)
);

CREATE TABLE CategoryQuestion (
    categoryID INT,
    categoryName VARCHAR(30)
);

CREATE TABLE `Question` (
    questionID INT,
    content VARCHAR(30),
    categoryID INT,
    typeID INT,
    creatorID INT,
    createDate DATE
);

CREATE TABLE `answer` (
    answerID INT,
    content VARCHAR(30),
    questionID INT,
    isCorrect BOOLEAN
);

CREATE TABLE Exam (
    examID INT,
    `code` INT,
    title VARCHAR(30),
    categoryID INT,
    duration TIME,
    creatorID INT,
    createDate DATE
);

CREATE TABLE ExamQuestion (
    examID INT,
    questionID INT
);