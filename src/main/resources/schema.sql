create table members (
    mno int auto_increment primary key,
    userid varchar(18) unique not null,
    userpwd varchar(64) not null ,
    name varchar(50) not null null,
    email varchar(100) not null,
    regdate datetime default  current_timestamp
);