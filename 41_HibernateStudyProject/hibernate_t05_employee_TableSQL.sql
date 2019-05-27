/*--多對一-------------------------------------------------------*/
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

/*--一對一-------------------------------------------------------*/
create table hibernate_t05_company(
	cid int(3) primary key auto_increment,
    cname varchar(100),
    aid int(3) references hibernate_t05_address
);

create table hibernate_t05_address(
	aid int(3) primary key auto_increment,
    country varchar(100),
    city varchar(100),
    street varchar(100)
);

select * from hibernate_t05_company;
select * from hibernate_t05_address;

/*--多對多-------------------------------------------------------*/
create table hibernate_t05_course(
	cid int(3) primary key auto_increment,
    cname varchar(100)
);

create table hibernate_t05_student(
	sid int(3) primary key auto_increment,
    sname varchar(100)
);

create table hibernate_t05_student_course(
	sid int(3),
    cid int(3)
);

select * from hibernate_t05_course;
select * from hibernate_t05_student;
select * from hibernate_t05_student_course;

