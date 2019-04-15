create table hibernate_t04_student(
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    major varchar(50),
    primary key(firstname, lastname)
);

drop table hibernate_t04_student;
 
insert into hibernate_t04_studentid values
('mickey', 'anna'), 
('mike', 'jack');

select * from hibernate_t04_student;

create table hibernate_t04_stdent(
	column_key varchar(100),
    major varchar(50)
);

select * from hibernate_t04_stdent;

create table hibernate_t04_person(
	id int(5) primary key auto_increment,
    name varchar(50),
    city varchar(50),
    street varchar(50),
    zipcode int(6)
);
select * from hibernate_t04_person;
drop table hibernate_04_person;

create table hibernate_t04_address(
	id int(5) primary key auto_increment,
    city varchar(50),
    street varchar(50),
    zipcode int(6)
);
drop table hibernate_t04_address;
select * from hibernate_t04_address;