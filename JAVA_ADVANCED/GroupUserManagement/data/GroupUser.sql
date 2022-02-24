-- create database
DROP DATABASE IF EXISTS group_user_management ;
CREATE DATABASE group_user_management;
USE group_user_management;


-- create table: group
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`(
	groupID 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    groupName 				NVARCHAR(30) NOT NULL UNIQUE KEY,
    creatorID				INT UNSIGNED NOT NULL,
	createDate				DATETIME DEFAULT NOW(), -- Cannot update this field
    modifyDate				DATETIME DEFAULT NOW()

);

-- create table: Account
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
	userID					INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    email					VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
    username				VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
	`password` 				VARCHAR(800) NOT NULL,
    firstName				NVARCHAR(50) NOT NULL,
    lastName				NVARCHAR(50) NOT NULL,	-- create field fullName in POJO
    groupID 				INT UNSIGNED,	-- Set default waiting
    createDate				DATETIME DEFAULT NOW(), -- Cannot update this field
	`role` 					ENUM('User','Manager') NOT NULL DEFAULT 'User',
    `status`				INT DEFAULT 0  , -- 0: not active, 1:active
    FOREIGN KEY(groupID) REFERENCES `group`(groupID)	ON DELETE SET NULL
);

-- create table Registration_User_Token
DROP TABLE IF EXISTS registration_user_token;
CREATE TABLE registration_user_token(
	id						INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    token					CHAR(36) NOT NULL UNIQUE,
    user_id					INT UNSIGNED NOT NULL,
    expirationDate			DATETIME NOT NULL
);

-- create table Reset_Password_Token
DROP TABLE IF EXISTS reset_password_token;
CREATE TABLE reset_password_token(
	id						INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    token					CHAR(36) NOT NULL UNIQUE,
    user_id					INT UNSIGNED NOT NULL,
    expirationDate			DATETIME NOT NULL
);
