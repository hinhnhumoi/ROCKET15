/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/

-- Add data group
INSERT INTO `group`		(groupName		,	creatorID	,		CreateDate,				ModifyDate		) 
VALUES
						(N'Marketing'	,		2		, 		'2020-03-05'	, 		'2020-03-05'	),
						(N'Sale'		,		6		,		'2020-03-05'	,		'2020-03-05'	),
						(N'Bảo vệ'		,		4		,		'2020-03-07'	,		'2020-03-07'	),
						(N'Nhân sự'		,		6		,		'2020-03-08'	,		'2020-03-08'	),
						(N'Kỹ thuật'	,		7		,		'2020-03-10'	,		'2020-03-10'	),
						(N'Tài chính'	,		9		, 		'2020-03-05'	, 		'2020-03-05'	),
						(N'Phó giám đốc',		1		,		'2020-03-05'	,		'2020-03-05'	),
						(N'Giám đốc'	,		7		,		'2020-03-07'	,		'2020-03-07'	),
						(N'Thư kí'		,		3		,		'2020-03-08'	,		'2020-03-08'	),
						(N'Bán hàng'	,		6		,		'2020-03-10'	,		'2020-03-10'	),
						(N'Chạy vặt'	,		9		,		NOW()			,		NOW()			),
						(N'Cung ứng'	,		6		,		NOW()			,		NOW()			),
						(N'Kế Toán'		,		1		,		'2020-03-10'	,		'2020-03-10'	);


                                        

-- Add data `user`
-- pass: 123456
INSERT INTO `user`	(email								,	`password`														, username			, firstName		,lastName				, 		groupID			, 	createDate	,	`role`			)
VALUES 				('haidang29productions@gmail.com'	,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'dangblack'		,'Dang'			,		'Nguyen Hai'	,   		'5'			, 	'2020-03-05',	'Manager'		),
					('account1@gmail.com'				,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'quanganh'		,'Anh'			,		'Tong Quang'	,   		'1'			,	'2020-03-05',	'Manager'		),
                    ('account2@gmail.com'				,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'vanchien'		,'Chien'		,		'Nguyen Van'	,   		'2'			,	'2020-03-07',	'User'			),
                    ('account3@gmail.com'				,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'cocoduongqua'	,'Do'			,		'Duong'			,   		'3'			,	'2020-03-08',	'User'			),
                    ('account4@gmail.com'				,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'doccocaubai'		,'Thang'		,		'Nguyen Chien'  ,   		'4'			,	'2020-03-10',	'User'			),
                    ('dapphatchetngay@gmail.com'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'khabanh'			,'Kha'			,		'Ngo Ba'		,   		'6'			,	NOW()		,	'User'			),
                    ('songcodaoly@gmail.com'			,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'huanhoahong'		,'Huan'			,		'Bui Xuan'		,   		'7'			,	NOW()		,	'User'			),
                    ('sontungmtp@gmail.com'				,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'tungnui'			,'Tung'			,		'Nguyen Thanh'	,   		'8'			,	'2020-04-07',	'Manager'		),
                    ('duongghuu@gmail.com'				,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'duongghuu'		,'Huu'			,		'Duong Van'		,   		'9'			,	'2020-04-07',	'User'			),
                    ('vtiaccademy@gmail.com'			,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	, 'vtiaccademy'		,'Ai'			,		'Vi Ti'			,   		'10'		,	'2020-04-09',	'Manager'		);
                    
ALTER TABLE `group`
ADD FOREIGN KEY (creatorID) REFERENCES `user`(userID)
