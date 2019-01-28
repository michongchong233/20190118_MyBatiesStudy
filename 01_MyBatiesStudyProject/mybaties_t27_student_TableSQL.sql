create table mybaties_t27_teacher(
	tid int(10) primary key auto_increment,
    tname varchar(20)
);

insert into mybaties_t27_teacher values
(default, 'teacher_01'),
(default, 'teacher_02'),
(default, 'teacher_03'),
(default, 'teacher_04');

create table mybateis_t27_student(
	id int(10) primary key auto_increment,
    name varchar(20) not null,
    age int(3) not null,
    tid int(10) not null,
    foreign key (tid) references mybaties_t27_teacher(tid)
);

insert into mybateis_t27_student values
(default, 'student_1', 22, 1), 
(default, 'student_2', 30, 1), 
(default, 'student_3', 52, 3), 
(default, 'student_4', 42, 1), 
(default, 'student_5', 26, 4), 
(default, 'student_6', 63, 2), 
(default, 'student_7', 38, 3), 
(default, 'student_8', 16, 3), 
(default, 'student_9', 24, 3), 
(default, 'student_11', 25, 4), 
(default, 'student_12', 32, 3), 
(default, 'student_13', 61, 2), 
(default, 'student_14', 28, 2), 
(default, 'student_15', 39, 1), 
(default, 'student_16', 16, 1), 
(default, 'student_17', 51, 3), 
(default, 'student_18', 21, 3), 
(default, 'student_19', 35, 4), 
(default, 'student_20', 62, 4), 
(default, 'student_21', 16, 3), 
(default, 'student_22', 63, 2), 
(default, 'student_23', 24, 3);

select * from mybateis_t27_student
where name like "%_1%" and tid in (select tid from mybaties_t27_teacher where tname like "%t%")
limit 2,4;

select count(*) from mybateis_t27_student limit 2,4;

select tid from mybaties_t27_teacher where tname like "%tea%";

select * from mybateis_t27_student s left join mybaties_t27_teacher t on s.tid=t.tid;

drop table mybateis_t27_student;
drop table mybaties_t27_teacher;
