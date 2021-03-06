create table customer (id integer not null auto_increment, active bit, contact varchar(255), delivery_address varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table delivery (id integer not null auto_increment, delivery_date date, delivery_man varchar(255), shopping_date date, order_id integer, primary key (id)) engine=InnoDB;
create table item (id integer not null auto_increment, description varchar(255), price float, weight float, primary key (id)) engine=InnoDB;
create table order (id integer not null auto_increment, create_date date, order_status varchar(255), customer_id integer, primary key (id)) engine=InnoDB;
create table order_detail (item_id integer not null, order_id integer not null, qty integer, tax float, primary key (item_id, order_id)) engine=InnoDB;
alter table delivery add constraint FKq6ukhimca38xyc8oy2gtyur55 foreign key (order_id) references order (id);
alter table order add constraint FKb8tboo4d95mh8gavvovwbb7vg foreign key (customer_id) references customer (id);
alter table order_detail add constraint FK4dtqbi7ilse9x730y087wagm2 foreign key (item_id) references item (id);
alter table order_detail add constraint FKaydqce0v3jdgl2dl528xdmnt0 foreign key (order_id) references item (id);
create table customer (id integer not null auto_increment, active bit, contact varchar(255), delivery_address varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table delivery (id integer not null auto_increment, delivery_date date, delivery_man varchar(255), shopping_date date, order_id integer, primary key (id)) engine=InnoDB;
create table item (id integer not null auto_increment, description varchar(255), price float, weight float, primary key (id)) engine=InnoDB;
create table order_table (id integer not null auto_increment, create_date date, order_status varchar(255), customer_id integer, primary key (id)) engine=InnoDB;
create table order_detail (item_id integer not null, order_id integer not null, qty integer, tax float, primary key (item_id, order_id)) engine=InnoDB;
alter table delivery add constraint FKow0k0q8mipoqtop2l5lpam5j0 foreign key (order_id) references order_table (id);
alter table order_table add constraint FKdit09e676nqbguvt1k1w8mlj2 foreign key (customer_id) references customer (id);
alter table order_detail add constraint FK4dtqbi7ilse9x730y087wagm2 foreign key (item_id) references item (id);
alter table order_detail add constraint FKaydqce0v3jdgl2dl528xdmnt0 foreign key (order_id) references item (id);
create table customer (id integer not null auto_increment, active bit, contact varchar(255), delivery_address varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table delivery (id integer not null auto_increment, delivery_date date, delivery_man varchar(255), shopping_date date, order_id integer, primary key (id)) engine=InnoDB;
create table item (id integer not null auto_increment, description varchar(255), price float, weight float, primary key (id)) engine=InnoDB;
create table order_table (id integer not null auto_increment, create_date date, order_status varchar(255), customer_id integer, primary key (id)) engine=InnoDB;
create table order_detail (item_id integer not null, order_id integer not null, qty integer, tax float, primary key (item_id, order_id)) engine=InnoDB;
alter table delivery add constraint FKow0k0q8mipoqtop2l5lpam5j0 foreign key (order_id) references order_table (id);
alter table order_table add constraint FKdit09e676nqbguvt1k1w8mlj2 foreign key (customer_id) references customer (id);
alter table order_detail add constraint FK4dtqbi7ilse9x730y087wagm2 foreign key (item_id) references item (id);
alter table order_detail add constraint FKaydqce0v3jdgl2dl528xdmnt0 foreign key (order_id) references item (id);
