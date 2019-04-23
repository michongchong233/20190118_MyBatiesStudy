create table hibernate_t05_employee(
	eid int(5) primary key auto_increment,
    ename varchar(100),
    did int(5) references hibernate_t05_department(did)
);

insert into hibernate_t05_employee values
(default, 'mickey', 1),
(default, 'mike', 1),
(default, 'ben', 2),
(default, 'cola', 1)
;

select * from hibernate_t05_department;
select * from hibernate_t05_employee;

drop table hibernate_t05_department;
drop table hibernate_t05_employee;

create table hibernate_t05_department(
	did int(5) primary key auto_increment,
    dname varchar(100),
    location varchar(100)
);

insert into hibernate_t05_department values
(default, 'marketing', 'Taipei'),
(default, 'accounting', 'ShangHai');

select * from hibernate_t05_department;
