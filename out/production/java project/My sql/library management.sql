create database Login_page;
show databases;
use Login_page;

create table login
(Suser varchar(20),Smails varchar(30), Spasswords varchar(30));

select*from login;


create table  addUser
(Urollno int Not null primary key auto_increment,
Username varchar(30) not null,
Fathername varchar(30) not null,
Ucourse varchar(20)not null,
validupto int  not null);

select *from adduser;


create table addBook
(b_id int(11) not null primary key,
book_isbn varchar(40) not null,
book_name varchar(50) not null,
book_publisher varchar(50) not null,
book_edition varchar(20) not null,
book_gene varchar(20) not null,
book_price int(11) not null,
book_pages int(11) not null);

select*from addBook;

create table issueBook
(Issue_Id int (11) not null auto_increment primary key,
 Urollno int (11) not null primary key,
 b_id int(11) not null primary key,
 Issue_date varchar(30) not null,
 Period varchar(20) not null,
 foreign key(b_id)references addBook (b_id),
 foreign key(Urollno)references addUser (Urollno));
 
 select *from issueBook;
 
 create table returnBook
 (return_id int(11) not null,
 b_id int(11) not null primary key,
 Urollno int(11) not null,
 return_date varchar(50) not null,
 fine int(11) not null,
 foreign key(b_id)references addBook (b_id),
 foreign key(Urollno)references addUser (Urollno));
 
 alter table returnBook
 add column issue_date int(11) not null;
  
  alter table returnBook
  drop column issue_date;
   
 
  
 
 select * from  returnBook;
 
 
 
 
 


