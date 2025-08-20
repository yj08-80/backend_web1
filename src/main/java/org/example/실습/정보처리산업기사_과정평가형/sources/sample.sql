drop database if exists assessment;
create database assessment;
use assessment;

create table member_tbl_02(
	custno int not null auto_increment,
    custname varchar(20) null,
    phone varchar(13) null,
    address varchar(60) null,
    joindate date null,
    grade char(1) null,
    city char(2) null,
    constraint primary key ( custno )
);

create table money_tbl_02(
	custno int not null,
    salenol int not null auto_increment,
    pcost int null,
    amount int null,
    price int null,
    pcode varchar(4) null,
    sdate date null,
    constraint primary key ( salenol ),
    constraint fk_money_member foreign key ( custno ) references member_tbl_02( custno )
);

insert into member_tbl_02( custno , custname , phone , address , joindate , grade , city ) values ( 100001 , "김행복" , "010-1111-2222" , "서울 동대문구 휘경1동" , "2015-12-02" , 'A' , '01' );
insert into member_tbl_02( custno , custname , phone , address , joindate , grade , city ) values ( 100002 , "이축복" , "010-1111-3333" , "서울 동대문구 휘경2동" , "2015-12-06" , 'B' , '01' );
insert into member_tbl_02( custno , custname , phone , address , joindate , grade , city ) values ( 100003 , "장믿음" , "010-1111-4444" , "울릉군 울릉읍 독도1리" , "2015-10-01" , 'B' , '30' );
insert into member_tbl_02( custno , custname , phone , address , joindate , grade , city ) values ( 100004 , "최사랑" , "010-1111-5555" , "울릉군 울릉읍 독도2리" , "2015-11-13" , 'A' , '30' );
insert into member_tbl_02( custno , custname , phone , address , joindate , grade , city ) values ( 100005 , "진평화" , "010-1111-6666" , "제주도 제주시 외나무골" , "2015-12-25" , 'B' , '60' );
insert into member_tbl_02( custno , custname , phone , address , joindate , grade , city ) values ( 100006 , "자공단" , "010-1111-7777" , "제주도 제주시 감나무골" , "2015-12-11" , 'C' , '60' );

insert into money_tbl_02( custno , salenol , pcost , amount , price , pcode , sdate ) values ( 100001 , 20160001 , 500 , 5 , 2500 , "A001" , "2016-01-01" );
insert into money_tbl_02( custno , salenol , pcost , amount , price , pcode , sdate ) values ( 100001 , 20160002 , 1000 , 4 , 4000 , "A002" , "2016-01-01" );
insert into money_tbl_02( custno , salenol , pcost , amount , price , pcode , sdate ) values ( 100001 , 20160003 , 500 , 3 , 1500 , "A008" , "2016-01-01" );
insert into money_tbl_02( custno , salenol , pcost , amount , price , pcode , sdate ) values ( 100002 , 20160004 , 500 , 1 , 500 , "A001" , "2016-01-03" );
insert into money_tbl_02( custno , salenol , pcost , amount , price , pcode , sdate ) values ( 100003 , 20160005 , 1500 , 2 , 3000 , "A003" , "2016-01-03" );
insert into money_tbl_02( custno , salenol , pcost , amount , price , pcode , sdate ) values ( 100004 , 20160006 , 500 , 2 , 1000 , "A001" , "2016-01-04" );
insert into money_tbl_02( custno , salenol , pcost , amount , price , pcode , sdate ) values ( 100004 , 20160007 , 300 , 1 , 300 , "A005" , "2016-01-04" );
insert into money_tbl_02( custno , salenol , pcost , amount , price , pcode , sdate ) values ( 100004 , 20160008 , 600 , 1 , 600 , "A006" , "2016-01-04" );
insert into money_tbl_02( custno , salenol , pcost , amount , price , pcode , sdate ) values ( 100004 , 20160009 , 3000 , 1 , 3000 , "A007" , "2016-01-04" );


select * from member_tbl_02;
select * from money_tbl_02;
