
-- Password create using BCrypt (https://bcrypt-generator.com)
-- password = admin
insert into tb_user (name, email, password) values ('Rafael Cancian admin', 'cancian.admin@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
-- password = operator
insert into tb_user (name, email, password) values ('Rafael Cancian operator', 'cancian.operator@gmail.com', '$2y$12$uzotlvyycDlsK/IYORt4BOrWYJKEB5o8enrWc.WCrLTOVLYi0H9Uq');

insert into tb_role (role_name) values ('ROLE_OPERATOR');
insert into tb_role (role_name) values ('ROLE_ADMIN');

insert into tb_user_role (user_id, role_id) values (1, 1);
insert into tb_user_role (user_id, role_id) values (1, 2);
insert into tb_user_role (user_id, role_id) values (2, 1);
insert into tb_user_role (user_id, role_id) values (2, 2);
