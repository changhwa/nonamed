
insert into department(dept_code, dept_name, level, parent_id) values (1,'테스트부서1',0,null);
insert into department(dept_code, dept_name, level, parent_id) values (2,'테스트부서2',1,1);
insert into department(dept_code, dept_name, level, parent_id) values (3,'테스트부서2-1',1,2);
insert into department(dept_code, dept_name, level, parent_id) values (4,'테스트부서2-1-1',2,3);
insert into department(dept_code, dept_name, level, parent_id) values (5,'테스트부서3',1,1);
insert into department(dept_code, dept_name, level, parent_id) values (6,'테스트부서4',1,1);
insert into department(dept_code, dept_name, level, parent_id) values (7,'테스트부서1-1',1,1);


insert into users(email, passwd, name) values ('test1@nonamed.co.kr','@test1!','테스터1');
insert into users(email, passwd, name) values ('test2@nonamed.co.kr','@test2!','테스터2');
insert into users(email, passwd, name) values ('test3@nonamed.co.kr','@test3!','테스터3');
insert into users(email, passwd, name) values ('test4@nonamed.co.kr','@test3!','테스터4');
insert into users(email, passwd, name) values ('test5@nonamed.co.kr','@test3!','테스터5');
insert into users(email, passwd, name) values ('test6@nonamed.co.kr','@test3!','테스터6');
insert into users(email, passwd, name) values ('test7@nonamed.co.kr','@test3!','테스터7');
insert into users(email, passwd, name) values ('test8@nonamed.co.kr','@test3!','테스터8');
insert into users(email, passwd, name) values ('test9@nonamed.co.kr','@test3!','테스터9');
insert into users(email, passwd, name) values ('test10@nonamed.co.kr','@test3!','테스터10');
insert into users(email, passwd, name) values ('test11@nonamed.co.kr','@test3!','테스터11');
insert into users(email, passwd, name) values ('test12@nonamed.co.kr','@test3!','테스터12');
insert into users(email, passwd, name) values ('test13@nonamed.co.kr','@test3!','테스터13');
insert into users(email, passwd, name) values ('test14@nonamed.co.kr','@test3!','테스터14');
insert into users(email, passwd, name) values ('test15@nonamed.co.kr','@test3!','테스터15');
insert into users(email, passwd, name) values ('test16@nonamed.co.kr','@test3!','테스터16');
insert into users(email, passwd, name) values ('test17@nonamed.co.kr','@test3!','테스터17');
insert into users(email, passwd, name) values ('test18@nonamed.co.kr','@test3!','테스터18');


insert into user_dept(user_id, dept_id) values('test1@nonamed.co.kr',1);
insert into user_dept(user_id, dept_id) values('test2@nonamed.co.kr',1);
insert into user_dept(user_id, dept_id) values('test3@nonamed.co.kr',2);
insert into user_dept(user_id, dept_id) values('test4@nonamed.co.kr',3);
insert into user_dept(user_id, dept_id) values('test5@nonamed.co.kr',4);
insert into user_dept(user_id, dept_id) values('test6@nonamed.co.kr',2);
insert into user_dept(user_id, dept_id) values('test7@nonamed.co.kr',5);
insert into user_dept(user_id, dept_id) values('test8@nonamed.co.kr',6);
insert into user_dept(user_id, dept_id) values('test9@nonamed.co.kr',7);
insert into user_dept(user_id, dept_id) values('test10@nonamed.co.kr',1);
insert into user_dept(user_id, dept_id) values('test11@nonamed.co.kr',2);
insert into user_dept(user_id, dept_id) values('test12@nonamed.co.kr',2);
insert into user_dept(user_id, dept_id) values('test13@nonamed.co.kr',3);
insert into user_dept(user_id, dept_id) values('test14@nonamed.co.kr',4);
insert into user_dept(user_id, dept_id) values('test15@nonamed.co.kr',5);
insert into user_dept(user_id, dept_id) values('test16@nonamed.co.kr',6);
insert into user_dept(user_id, dept_id) values('test17@nonamed.co.kr',6);
insert into user_dept(user_id, dept_id) values('test18@nonamed.co.kr',7);
