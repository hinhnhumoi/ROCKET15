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

INSERT INTO Trainee (Full_name, Birth_Date,Gender,ET_IQ,ET_Gmath,ET_English,Training_Class)
VALUES				( 'Nguyen Van A','2000-01-28','male',10,15,20,'Class1'),
					( 'Nguyen Van B','2000-02-18','male',11,15,10,'Class1'),
                    ( 'Nguyen Van C','2000-03-28','male',12,15,13,'Class2'),
                    ( 'Nguyen Thi D','2000-04-25','female',11,14,20,'Class2'),
                    ( 'Nguyen Van E','2000-06-17','male',10,12,17,'Class2'),
                    ( 'Nguyen Thi F','2000-07-18','female',08,15,13,'Class3'),
                    ( 'Nguyen Van G','2000-08-08','male',09,15,12,'Class1'),
                    ( 'Nguyen Van Hieu','2000-09-03','male',10,14,20,'Class1'),
                    ( 'Nguyen Van I','2000-11-02','unknown',13,15,7,'Class3'),
                    ( 'Nguyen Thi J','2000-10-11','female',10,8,12,'Class1');
SELECT * FROM Trainee;
SELECT month(Birth_date), count(*) as total , group_concat(Full_name) as list_trainee from trainee group by month(Birth_date);
select Full_name, 2021- year(birth_date), char_length(Full_name) from trainee order by char_length(Full_name) desc limit 1;
SELECT * FROM trainee where ET_IQ >= 8 AND ET_Gmath >=8 AND ET_English >= 18 AND (ET_IQ + ET_Gmath) >= 20;
delete from trainee where TraineeID=3;
update Trainee set training_Class ='class2' where TraineeID=3;