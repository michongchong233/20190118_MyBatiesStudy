create table rbac_t01_menu_user(
	id int(10) primary key auto_increment,
    uid int(10) not null,
    mid int(10) not null
);

select *  from rbac_t01_menu_user;

/*新增全開菜單權限的用戶*/
insert into rbac_t01_menu_user values
(default, 1, 1),
(default, 1, 2),
(default, 1, 3),
(default, 1, 4),
(default, 1, 5),
(default, 1, 6);

/*新增部分菜單權限的用戶*/
insert into rbac_t01_menu_user values
(default, 2, 1),
(default, 2, 2),
(default, 2, 3);