alter table department add constraint FK_pckwqaicar1mpn27equblhqgh foreign key (parent_id) references department(dept_code);
alter table user_dept add constraint FK_94grc1sqoxpwc89sslv6loso7 foreign key (dept_id) references department(dept_code);
alter table user_dept add constraint FK_fbmku3igmuct0yxy3uwsu99do foreign key (user_id) references users(email);