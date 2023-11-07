create database studentmana;
use studentmana;
create table student(
    id int primary key auto_increment,
    name varchar(255),
    email varchar(255),
    dateOfBirth date,
    address varchar(255),
    phoneNumber varchar(10),
    classRoomId int,
    FOREIGN KEY (classRoomId) REFERENCES classRoom(id)
);
create table classRoom(
    id int primary key auto_increment,
    className varchar(255)
);
ALTER TABLE student
    MODIFY COLUMN dateOfBirth varchar(255);
INSERT INTO classRoom(className) values ('C0723G1');
INSERT INTO student (name, email, dateOfBirth, address, phoneNumber, classRoomId)
VALUES ('thang','thang@gmail.com','2001-04-20','thái bình','0123654792',1);
select s.*,cR.className from student s join classRoom cR on cR.id = s.classRoomId;
select *from classRoom;
update student set name =?,email=?,dateOfBirth=?,address=?,phoneNumber=?,classRoomId=?where id=?;