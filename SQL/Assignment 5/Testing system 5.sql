select a.StudentID,a.`Name` from student as a inner join marks as b on a.StudentID=b.StudentID where b.total_marks >
																													(Select total_marks from marks where StudentId = 'v002');
use CongtyABC;
drop view if exists Q1;
CREATE VIEW Q1 AS
    SELECT  a.username, b.departmentName
    FROM `Account` AS a
            INNER JOIN
        Department AS b ON a.departmentID = b.departmentID
    WHERE
        b.departmentName = 'Sales';
select * from Q1;
drop view if exists Q2;
CREATE VIEW Q2 AS
    SELECT a.accountID,a.username, a.fullname, COUNT(b.groupID)
    FROM `Account` AS a
            INNER JOIN
        GroupAccount AS b ON a.accountID = b.accountID
    GROUP BY a.accountID
    HAVING COUNT(b.groupID) = (SELECT COUNT(groupID)
								FROM	 GroupAccount
								GROUP BY accountID
								order by COUNT(groupID) DESC LIMIT 1);
select * from Q2;
drop view if exists Q3;
create view Q3 as 
select questionID,content, char_length(content) from `Question` where char_length(content)>300;

drop view if exists Q4;
create view Q4 as
SELECT  departmentName, COUNT(accountID) AS so_nv
FROM department AS a INNER JOIN `Account` AS b ON a.departmentID = b.departmentID
GROUP BY a.departmentID
HAVING COUNT(accountID) = (SELECT COUNT(accountID)
							FROM `Account`
							GROUP BY departmentID
							ORDER BY COUNT(accountID) DESC LIMIT 1);
select * from Q4;

drop view if exists Q5;
CREATE VIEW Q5 AS
    SELECT creatorID, questionID
    FROM `Question`
    WHERE creatorID = (SELECT  accountID  
						FROM `Account`
						WHERE fullname LIKE N'Nguyễn');
select * from Q5;
