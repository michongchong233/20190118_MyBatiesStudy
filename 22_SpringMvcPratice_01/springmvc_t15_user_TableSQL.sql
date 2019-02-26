use dbtest;

create table springmvc_t15_user(
	id int(10) primary key auto_increment,
    username varchar(255),
    password varchar(255),
    photo varchar(255)
);

select * from springmvc_t15_user;