create table t10_menu(
	id int(10) primary key auto_increment,
    name varchar(255),
    pid int(10)
);

insert into t10_menu values
(default, '系統設置',0 ),
(default, '銷售管理',0 ),
(default, '添加用戶',1 ),
(default, '修改密碼',1 ),
(default, '新增銷售用戶',2 ),
(default, '刪除銷售用戶',2 );

select * from t10_menu;
select * from t10_menu where pid=1;