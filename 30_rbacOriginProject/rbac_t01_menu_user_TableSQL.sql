create table rbac_t01_menu_user(
	id int(10) primary key auto_increment,
    uid int(10) not null,
    mid int(10) not null
);

select * from rbac_t01_menu_user;
select * from t10_menu m right join rbac_t01_menu_user u 
	on m.id = u.mid
    where u.uid = 11;

/*新增全開菜單權限的用戶*/
insert into rbac_t01_menu_user values
(default, 12, 1),
(default, 12, 2),
(default, 12, 3),
(default, 12, 4),
(default, 12, 5),
(default, 12, 6);

/*新增部分菜單權限的用戶*/
insert into rbac_t01_menu_user values
(default, 11, 1),
(default, 11, 2),
(default, 11, 3);

/*
角色表：角色id、角色名
*/
create table rbac_t03_actor(
	id int(10) primary key auto_increment,
    name varchar(255) not null unique
);
insert into rbac_t01_actor values 
(default, '權限全開用戶'),
(default, '權限部分開啟用戶_01'),
(default, '權限部分開啟用戶_02');
select * from rbac_t03_actor;

/*角色菜單對應表*/
create table rbac_t03_actor_menu(
	id int(10) primary key auto_increment,
    aid int(10) not null,
    mid int(10) not null
);
select * from rbac_t03_actor_menu;
/*新增權限全開用戶權限*/
insert into rbac_t03_actor_menu values
(default, 1, 1),
(default, 1, 2),
(default, 1, 3),
(default, 1, 4),
(default, 1, 5),
(default, 1, 6);
/*新增權限部分開啟用戶*/
insert into rbac_t03_actor_menu values
(default, 3, 4),
(default, 3, 5),
(default, 3, 6);

/*用戶角色對應表*/
create table rbac_t03_user_actor(
	id int(10) primary key auto_increment,
    uid int(10) not null,
    aid int(10) not null
);
select * from rbac_t03_user_actor;
insert into rbac_t03_user_actor values
(default, 11, 1),
(default, 12, 2);

/*根據用戶編號查詢此用戶相關權限的菜單*/
select 
	u.id		as user_id,
    u.username	as user_name,
    ua.aid		as actor_id,
    a.name		as actor_name,
    m.name		as menu_name
from springmvc_t15_user as u /*用戶表*/
	left join rbac_t03_user_actor as ua /*用戶角色對應表*/
		on u.id = ua.uid
	left join rbac_t03_actor as a/*角色表*/
		on ua.aid = a.id
	left join rbac_t03_actor_menu as am/*角色菜單對應表*/
		on ua.aid = am.aid
	left join t10_menu as m
		on am.mid = m.id
where u.id = 11;
select * from springmvc_t15_user;