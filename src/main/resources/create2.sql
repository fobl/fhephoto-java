drop table if exists orderline;
drop table if exists image;
drop table if exists customer;
drop table if exists photographer;
drop table if exists user;
drop table if exists gallery;

drop table if exists user;

create table user (
  user_id int not null auto_increment,
  email varchar(255) not null UNIQUE,
  firstname varchar(255),
  lastname varchar(255),
  mobilephone varchar(15),
  role enum('p', 'c', 'a'),
  password varchar(255),
  login_attempts int not null default 0,
  login_date date,
  login_key varchar(255),
  primary key(user_id)
);

create table photographer (
  photographer_id int not null auto_increment,
  account_number int,
  user_id  int not null,
  foreign key (user_id) references user(user_id),
  primary key(photographer_id)
);

create table customer (
  customer_id int not null auto_increment,
  user_id  int not null,
  image_zip varchar(255),
  foreign key (user_id) references user(user_id),
  primary key(customer_id)
);

create table image (
  image_id int not null auto_increment,
  original_image varchar(255),
  thumbnail blob,
  watermarked blob,
  fullsize blob,
  photographer_id int,
  foreign key (photographer_id) references photographer(photographer_id),
  primary key(image_id)
);

create table gallery (
  gallery_id INT        NOT NULL AUTO_INCREMENT,
  image_id   INT        NOT NULL,
  user_id    INT        NOT NULL,
  print_price INT,
  image_price INT,
  currency   VARCHAR(3) NOT NULL,
  FOREIGN KEY (image_id) REFERENCES image (image_id),
  FOREIGN KEY (user_id) REFERENCES user (user_id),
  primary key(gallery_id)
);

# create table email (
#   email_id int not null auto_increment,
#   email_type varchar(20) not null,
#   customer_id int not null,
#   created_date date not null,
#   sent_date date,
#   value1 varchar(255),
#   foreign key (customer_id) references customer(customer_id),
#   primary key(email_id)
# );
#
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

insert into user(user_id, firstname, lastname, mobilephone, email, password, role) values(1, 'Frank', 'Evensen', 'xxxxxx', 'fhefoto@yahoo.no', '098f6bcd4621d373cade4e832627b4f6', 'a');
insert into user(user_id, firstname, lastname, mobilephone, email, password, role) values(2, 'Frode', 'Bjerkenes', 'xxxxxx', 'frode.bjerkenes@gmail.com', '098f6bcd4621d373cade4e832627b4f6', 'a');