drop table if exists orderline;
drop table if exists category;
drop table if exists image;
drop table if exists customer;

create table customer (
  customer_id int not null auto_increment,
  firstname varchar(255),
  lastname varchar(255),
  mobilephone varchar(15),
  email varchar(255) not null unique,
  password varchar(255),
  login_attempts int not null default 0,
  login_date date,
  login_key varchar(255),
  role varchar(1) default 'c',
  price int,
  image_zip varchar(255),
  primary key(customer_id)
);

create table category (
  category_id int not null auto_increment,
  title varchar(255),
  customer_id int not null,
  foreign key (customer_id) references customer(customer_id),
  primary key(category_id)
);

create table image (
  image_id int not null auto_increment,
  url varchar(255),
  image varchar(255),
  fullsize varchar(255),
  thumbnail varchar(255),
  customer_id int,
  bought int(1),
  foreign key (customer_id) references customer(customer_id),
  primary key(image_id)
);

create table orderline (
  orderline_id int not null auto_increment,
  order_id int not null,
  image_id int not null,
  customer_id int not null,
  price int not null,
  paid int(1) default 0,
  currency varchar(3) default 'EUR',
  foreign key (customer_id) references customer(customer_id),
  foreign key (image_id) references image(image_id),
  primary key(orderline_id),
  UNIQUE (image_id)
);

create table email (
  email_id int not null auto_increment,
  email_type varchar(20) not null,
  customer_id int not null,
  created_date date not null,
  sent_date date,
  value1 varchar(255),
  foreign key (customer_id) references customer(customer_id),
  primary key(email_id)
);

insert into customer(customer_id, firstname, lastname, mobilephone, email, password, role) values(1, 'Frank', 'Evensen', 'xxxxxx', 'fhefoto@yahoo.no', '098f6bcd4621d373cade4e832627b4f6', 'a');
insert into customer(customer_id, firstname, lastname, mobilephone, email, password, role) values(2, 'Frode', 'Bjerkenes', 'xxxxxx', 'frode.bjerkenes@gmail.com', '098f6bcd4621d373cade4e832627b4f6', 'a');
