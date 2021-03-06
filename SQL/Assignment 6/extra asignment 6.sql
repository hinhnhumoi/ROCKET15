DROP DATABASE IF EXISTS Extra6;
CREATE DATABASE Extra6;
use Extra6;
CREATE TABLE Employee
(
	EmployeeID           INT AUTO_INCREMENT PRIMARY KEY,
	EmployeeLastName     NVARCHAR(50) NOT NULL,
	EmployeeFirstName    NVARCHAR(50) NOT NULL,
	EmployeeHireDate 		 DATETIME DEFAULT NOW(),
	EmployeeStatus       BIT NOT NULL,
	SupervisorID         INT NOT NULL,
	SocialSecurityNumber VARCHAR(50) NOT NULL,
	FOREIGN KEY (SupervisorID) REFERENCES Employee(EmployeeID)
);
CREATE TABLE Projects
(
	ProjectID            INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	-- EmployeeID					 INT UNSIGNED NOT NULL,
	ProjectName          VARCHAR(50) NOT NULL,
	ProjectStartDate 	 DATETIME DEFAULT NOW(),
	ProjectDescription   VARCHAR(255) NULL,
	ProjectDetail        VARCHAR(255) NULL,
	ProjectCompletedOn   DATETIME
	-- ,FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
); 
CREATE TABLE Project_Modules
(
	ModuleID                  INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	ProjectID                 INT UNSIGNED NOT NULL,
	ProjectModulesDate    		DATETIME DEFAULT NOW(),
	ProjectModulesCompletedOn DATETIME ,
	ProjectModulesDescription VARCHAR(255) NULL,
	FOREIGN KEY (ProjectID) REFERENCES Projects(ProjectID)
); 
CREATE TABLE Work_Done
(
	WorkDoneID          INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	EmployeeID          INT NOT NULL,
	ModuleID            INT UNSIGNED NOT NULL,
	WorkDoneDate    DATETIME ,
	WorkDoneDescription VARCHAR(255) NULL,
	WorkDoneStatus      BIT(1) NULL,
	FOREIGN KEY (ModuleID) REFERENCES Project_Modules(ModuleID),
	FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
);

INSERT INTO Employee
VALUES	
(1, 'Đoàn Minh', 'Giang', '2019-06-06 00:00:00', b'1', 1, 'SS001'),
(2, 'Trương Việt', 'Anh', '2019-07-06 00:00:00', b'1', 1, 'SS002'),
(3, 'Nguyễn Đức', 'Mạnh', '2019-08-06 00:00:00', b'1', 2, 'SS003'),
(4, 'Nguyễn Văn', 'Đạt', '2019-07-06 00:00:00', b'0', 2, 'SS004'),
(5, 'Phạm Ngọc', 'Sơn', '2021-07-06 09:00:44', b'1', 4, 'SS005');

INSERT INTO `projects` VALUES
(1, 'Java', '2021-06-06 00:00:00', 'Dự án Java', 'Làm đúng hạn', '2021-08-06 00:00:00'),
(2, 'C#', '2021-07-06 00:00:00', 'Dự án C#', 'Làm trước hạn', '2021-09-06 00:00:00'),
(3, 'Android', '2021-08-06 00:00:00', 'Dự án Android', 'Làm quá hạn', '2021-10-06 00:00:00'),
(4, 'C++', '2021-07-06 00:00:00', 'Dự án C++', 'Làm trước hạn', '2021-11-06 00:00:00'),
(5, 'PHP', '2021-07-06 09:05:35', 'Dự án PHP', 'Làm đúng hạn', '2021-12-06 09:05:35');

INSERT INTO `project_modules` VALUES
(1, 1, '2019-06-06 00:00:00', '2019-06-06 00:00:00', 'Làm đúng hạn'),
(2, 2, '2019-07-06 00:00:00', null, 'chưa xong'),
(3, 3, '2019-08-06 00:00:00', '2019-09-06 00:00:00', 'Làm quá hạn'),
(4, 4, '2019-07-06 00:00:00', '2019-06-06 00:00:00', 'Làm trước hạn'),
(5, 5, '2021-07-06 09:09:31', '2021-08-06 09:09:31', 'Làm đúng hạn');

INSERT INTO `work_done` VALUES
(1, 1, 1, '2019-06-06 00:00:00', 'Hoàn thành', b'1'),
(2, 2, 2, '2019-07-06 00:00:00', 'Hoàn thành - kiểm duyệt', b'1'),
(3, 3, 3,null, 'Trong tiến trình', b'0'),
(4, 1, 4, '2019-07-06 00:00:00', 'Đang hoàn thành', b'0'),
(5, 5, 5, '2021-07-06 09:12:58', 'Trong tiến trình', b'1');

DROP PROCEDURE IF EXISTS B;
DELIMITER $$
CREATE PROCEDURE B ()
	BEGIN
    DELETE FROM  projects
    
    WHERE  curdate() - ProjectCompletedOn>='0000-03-00 00:00:00';
    END$$
DELIMITER ;


DROP PROCEDURE IF EXISTS C;
DELIMITER $$
CREATE PROCEDURE C (OUT IDmodule INT )
	BEGIN 
		SELECT ModuleID AS ModuleID INTO IDmodule
		FROM Project_Modules 
		WHERE ProjectModulesCompletedOn='2021-07-06 09:12:58';
    END$$
DELIMITER ;

SET @moduleId = 0;
CALL C ( @moduleId );
SELECT @moduleId;

DROP FUNCTION IF EXISTS D;
DELIMITER $$
CREATE FUNCTION D () RETURNS  NVARCHAR(100)
	BEGIN
    DECLARE EmployeeName NVARCHAR(100);
    
    SELECT CONCAT(a.EmployeeLastName,' ',a.EmployeeFirstName) INTO EmployeeName
    FROM Employee AS a LEFT JOIN Work_Done AS b ON a.EmployeeID=b.EmployeeID
    WHERE 	a.EmployeeID=	(SELECT EmployeeID FROM Employee
							WHERE NOT EXISTS 
							(SELECT EmployeeID FROM Work_Done WHERE Employee.EmployeeID = Work_Done.EmployeeID));
                            
    RETURN EmployeeName;
    END$$
DELIMITER ;
SELECT D();

