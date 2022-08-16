CREATE DATABASE store;
CREATE TABLE countries(
code int PRIMARY KEY,
name varchar(20),
  continent_name varchar(20),
);
create table users(
  id int primary key ,
  full_name varchar(20) ,
  email varchar(20) unique,
  gender char(1) check('F' or 'M'),
  date_of_birth varchar(15),
  created_at datetime,
  continent_code int ,
  foreign key (continent_code) references countries(code)
);
CREATE TABLE orddrs(
id int PRIMARY KEY,
 user_id int ,
  status varchar(6) check( 'start' or 'finish'),
  foreign key (user_id) references users(id)
);
CREATE TABLE order_product(
order_id int  ,
  product_id int ,
  quantity int default 0,
  primary key (order_id,product_id),
  foreign key (order_id) references orders(id),
  foreign key (product_id) references products(id)
);
ALTER TABLE products ALTER COLUMN created_at SET DEFAULT now();




insert into countries values(123,'Saudi Arabia','Asia');
insert into users values(1,'Saeed','sueed5555@gmail.com','f','10/8/2000','2022-08-15 17:50:14',123);
insert into orders values(1,1,'start','2022-08-15 17:50:14');
insert into products values(1,'t',200,'valid','2022-08-15 17:50:14');
insert into order_products values(1,1,3);

update countries set name='Dobai' where code=123;
delete from products where id=1;