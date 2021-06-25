create database FresherManagement;
use FresherManagement;

-- Exercise 1:Design a table
CREATE TABLE Trainee (
    TraineeID INT,
    Full_Name VARCHAR(30),
    Birth_Date DATE,
    ET_IQ INT,
    ET_Gmath INT,
    ET_English INT,
    Training_Class VARCHAR(10),
    Evaluation_Notes TEXT
);

-- Exercise 2: Data Types
CREATE TABLE DAtatype1 (
    ID MEDIUMINT,
    Name VARCHAR(50),
    `Code` CHAR(5),
    ModifiedDate DATE
);