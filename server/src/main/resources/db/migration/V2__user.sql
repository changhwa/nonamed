create table users(
  email varchar(255) not null,
  passwd varchar(255),
  name varchar(255),
  department_deptCode bigint,
  primary key (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
