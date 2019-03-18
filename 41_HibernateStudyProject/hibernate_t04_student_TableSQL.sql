create table hibernate_t04_student(
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    major varchar(50),
    primary key(firstname, lastname)
);

drop table hibernate_t04_studentid;
 
insert into hibernate_t04_studentid values
('mickey', 'anna'), 
('mike', 'jack');

select * from hibernate_t04_studentid;

create table hibernate_t04_stdent(
	column_key varchar(100),
    major varchar(50)
);

select * from hibernate_t04_stdent;