
Use StudentMyBatis;

create table User(
userId INT AUTO_INCREMENT PRIMARY KEY,
username varchar(25) NOT NULL,
password varchar(25) NOT NULL,
role varchar(25) NOT NULL
);


create table Teacher(
teacherId INT AUTO_INCREMENT PRIMARY KEY,
teacherName varchar(25) NOT NULL,
level varchar(25) NOT NULL,
departmentId varchar(25) NOT NULL,
contactNumber varchar(10) NOT NULL
);



create table persistent_logins (
username varchar(64) not null,
series varchar(64) primary key,
token varchar(64) not null,
last_used timestamp not null);




insert into User value(1,'admin','password','ROLE_ADMIN');
insert into User value(2,'user','password','ROLE_USER');

INSERT INTO Teacher VALUE (10,'Rajesh Yadav','PGT','1','9876543212');
INSERT INTO Teacher VALUE (11,'Rakesh Yadav','PGT','2','999999999');

