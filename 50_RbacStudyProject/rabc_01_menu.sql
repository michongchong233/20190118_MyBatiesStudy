create table rabc_01_user_menu (
	id int(10) primary key auto_increment,
    uid int(10),
    mid int(10)
);

create table rabc_01_user(
	id int(10) primary key auto_increment,
    username varchar(255) not null,
    password varchar(255) not null
);

create table rabc_01_menu(
	id int(10) primary key auto_increment,
    menu_name varchar(255) not null,
    pid int(10) not null
);

select * from rabc_01_user_menu where uid=1;
select * from rabc_01_menu where id in (
	select * from rabc_01_user_menu where uid=1
);
