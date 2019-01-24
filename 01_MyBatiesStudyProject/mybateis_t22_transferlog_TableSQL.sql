create table mybateis_t22_transferlog(
transfer_id int(10) primary key auto_increment,
out_account varchar(255) not null,
in_account varchar(255) not null,
transfer_money double not null,
transfer_datetime datetime not null
);

select * from mybateis_t22_transferlog;