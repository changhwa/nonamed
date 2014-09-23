
insert into department(dept_code, dept_name, level, parent_id) values (1,'테스트부서1',0,null);
insert into department(dept_code, dept_name, level, parent_id) values (2,'테스트부서2',0,null);
insert into department(dept_code, dept_name, level, parent_id) values (3,'테스트부서2-1',1,2);
insert into department(dept_code, dept_name, level, parent_id) values (4,'테스트부서2-1-1',2,3);
insert into department(dept_code, dept_name, level, parent_id) values (5,'테스트부서3',0,null);
insert into department(dept_code, dept_name, level, parent_id) values (6,'테스트부서4',0,null);
insert into department(dept_code, dept_name, level, parent_id) values (7,'테스트부서1-1',1,1);


insert into users(email, passwd, name, department_deptCode) values ('test1@nonamed.co.kr','@test1!','테스터1',1);
insert into users(email, passwd, name, department_deptCode) values ('test2@nonamed.co.kr','@test2!','테스터2',2);
insert into users(email, passwd, name, department_deptCode) values ('test3@nonamed.co.kr','@test3!','테스터3',1);
insert into users(email, passwd, name, department_deptCode) values ('test4@nonamed.co.kr','@test3!','테스터4',1);
insert into users(email, passwd, name, department_deptCode) values ('test5@nonamed.co.kr','@test3!','테스터5',3);
insert into users(email, passwd, name, department_deptCode) values ('test6@nonamed.co.kr','@test3!','테스터6',4);
insert into users(email, passwd, name, department_deptCode) values ('test7@nonamed.co.kr','@test3!','테스터7',5);
insert into users(email, passwd, name, department_deptCode) values ('test8@nonamed.co.kr','@test3!','테스터8',5);
insert into users(email, passwd, name, department_deptCode) values ('test9@nonamed.co.kr','@test3!','테스터9',4);
insert into users(email, passwd, name, department_deptCode) values ('test10@nonamed.co.kr','@test3!','테스터10',3);
insert into users(email, passwd, name, department_deptCode) values ('test11@nonamed.co.kr','@test3!','테스터11',2);
insert into users(email, passwd, name, department_deptCode) values ('test12@nonamed.co.kr','@test3!','테스터12',1);
insert into users(email, passwd, name, department_deptCode) values ('test13@nonamed.co.kr','@test3!','테스터13',6);
insert into users(email, passwd, name, department_deptCode) values ('test14@nonamed.co.kr','@test3!','테스터14',6);
insert into users(email, passwd, name, department_deptCode) values ('test15@nonamed.co.kr','@test3!','테스터15',7);
insert into users(email, passwd, name, department_deptCode) values ('test16@nonamed.co.kr','@test3!','테스터16',6);
insert into users(email, passwd, name, department_deptCode) values ('test17@nonamed.co.kr','@test3!','테스터17',5);
insert into users(email, passwd, name, department_deptCode) values ('test18@nonamed.co.kr','@test3!','테스터18',2);