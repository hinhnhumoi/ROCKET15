DROP DATABASE IF EXISTS FresherManagement ;
create database FresherManagement;
use FresherManagement;

-- Exercise 1:Design a table
CREATE TABLE Trainee (
    TraineeID 			INT auto_increment NOT NULL PRIMARY KEY,
    Full_Name 			VARCHAR(50) NOT NULL,
    Birth_Date 			DATE,
    Gender 				ENUM ('male', 'female', 'unknown') DEFAULT ('unknown'),
    ET_IQ 				TINYINT unsigned, check(ET_IQ<=20),
    ET_Gmath 			TINYINT unsigned, check(ET_Gmath<=20),
    ET_English 			TINYINT unsigned, check(ET_English<=20),
    Training_Class 		VARCHAR(10) NOT NULL,
    Evaluation_Notes 	TEXT
);

ALTER TABLE Trainee 
add VTI_Account varchar(50) NOT NULL UNIQUE;

-- Exercise 2: Data Types
CREATE TABLE DAtatype1 (
    ID 				MEDIUMINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Name 			VARCHAR(50),
    `Code` 			CHAR(5),
    ModifiedDate 	DATE
);
-- Exercise 3: Data Types
CREATE TABLE DAtatype2 (
    ID 				MEDIUMINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Name 			VARCHAR(50) NOT NULL,
    BirthDate 		DATE NOT NULL,
    GENDER 			ENUM ('male', 'female', 'unknown') DEFAULT ('unknown'),
    ModifiedDate 	ENUM ('0'',1')
);