use dbtest;

create table springmvc_t15_user(
	id int(10) primary key auto_increment,
    username varchar(255),
    password varchar(255),
    photo varchar(255),
    downloadNum int(10) null default 0
);

select * from springmvc_t15_user;

insert into springmvc_t15_user values
(default, 'testuser_01', '1234', 'testPhoto_01'),
(default, 'testuser_02', '1234', 'testPhoto_02');

SET SQL_SAFE_UPDATES=0;/*解除輸入安全模式*/
update springmvc_t15_user set downloadNum=2 where photo='42649186-0bfc-46ba-ad3c-ce6cdc538ad1.png';