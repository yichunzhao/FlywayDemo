create table address (id bigint not null, building_number varchar(255), city varchar(255), country varchar(255), post_number varchar(255), street_name varchar(255), primary key (id)) engine=InnoDB;
create table address_employees (addresses_id bigint not null, employees_id bigint not null, primary key (addresses_id, employees_id)) engine=InnoDB;
alter table address_employees add constraint FKavhds2va9grfr3s058m0kswvo foreign key (employees_id) references employees (id);
alter table address_employees add constraint FKtikud24qutpm44er4afnp32o4 foreign key (addresses_id) references address (id);
