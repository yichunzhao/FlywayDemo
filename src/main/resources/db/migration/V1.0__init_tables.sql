create table employees
(
    id         bigint not null,
    firstname  varchar(256),
    lastname   varchar(256),
    start_date tinyblob,
    primary key (id)
) engine=InnoDB;
create table hibernate_sequence
(
    next_val bigint
) engine=InnoDB;
insert into hibernate_sequence
values (1);
create index Index_first_lastname on employees (firstname, lastname);
create index Index_last_firstname on employees (lastname, firstname);
