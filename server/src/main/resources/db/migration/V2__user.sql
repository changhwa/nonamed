create table users(
  email varchar(255) not null,
  passwd varchar(255),
  name varchar(255),
  primary key (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

insert into users(email, passwd, name) values ('test1@nonamed.co.kr','@test1!','테스터1');
insert into users(email, passwd, name) values ('test2@nonamed.co.kr','@test2!','테스터2');
insert into users(email, passwd, name) values ('test3@nonamed.co.kr','@test3!','테스터3');


