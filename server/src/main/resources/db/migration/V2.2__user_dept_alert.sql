alter table department add constraint FK_pckwqaicar1mpn27equblhqgh foreign key (parent_id) references department(dept_code);
alter table users add constraint FK_game5ym7d4bly3fnhuwkfuxf7 foreign key (department_deptCode) references department (dept_code);