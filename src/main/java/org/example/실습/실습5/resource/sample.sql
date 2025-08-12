drop database if exists test5;
create database test5;
use test5;

create table waiting(
		bno int auto_increment ,  
    phone  varchar(20) not null , 
    count  int not null ,
    constraint primary key(bno)
);

INSERT INTO waiting (phone, count) VALUES ('010-1111-2222', 3);
INSERT INTO waiting (phone, count) VALUES ('010-2222-3333', 5);
INSERT INTO waiting (phone, count) VALUES ('010-3333-4444', 2);
INSERT INTO waiting (phone, count) VALUES ('010-4444-5555', 4);
INSERT INTO waiting (phone, count) VALUES ('010-5555-6666', 1);
INSERT INTO waiting (phone, count) VALUES ('010-6666-7777', 6);
INSERT INTO waiting (phone, count) VALUES ('010-7777-8888', 2);
INSERT INTO waiting (phone, count) VALUES ('010-8888-9999', 3);
INSERT INTO waiting (phone, count) VALUES ('010-9999-0000', 5);
INSERT INTO waiting (phone, count) VALUES ('010-0000-1111', 4);

select * from waiting;