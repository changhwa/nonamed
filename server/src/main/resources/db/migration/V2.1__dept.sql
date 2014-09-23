create table department (
dept_code bigint AUTO_INCREMENT
, dept_name varchar(255)
, level integer not null
, use_yn varchar(255)
, parent_id bigint
, primary key (dept_code)) ;
