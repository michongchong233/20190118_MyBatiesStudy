create table mybateis_t21_acount(
	uid int(10) primary key auto_increment,
    account_name varchar(255) not null unique,
    password varchar(255) not null,
    uname varchar(255) not null,
    balance double not null    
);

insert into mybateis_t21_acount values 
	(default, 'aaaa', 'aaaa', 'Mickey', 5000),
	(default, 'bbbb', 'bbbb', 'Mike', 6400),
	(default, 'cccc', 'cccc', 'Ben', 800),
	(default, 'dddd', 'dddd', 'Tsai', 700),
	(default, 'eeee', 'eeee', 'Jennifer', 1000);

select * from mybateis_t21_acount;