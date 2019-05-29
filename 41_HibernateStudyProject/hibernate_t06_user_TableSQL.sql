create table hibernate_t06_user(
	uid int(3) primary key auto_increment,
    uname varchar(100),
    uage int(3),
    ubirth date
);

select * from hibernate_t06_user;
select count(*) from hibernate_t06_user;