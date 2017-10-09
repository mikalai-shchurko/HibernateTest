CREATE TABLE person
(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL
);

CREATE TABLE product
(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL
);

CREATE TABLE orders
(
  person_id INT NOT NULL ,
  product_id INT NOT NULL ,
  FOREIGN KEY (person_id) REFERENCES person(id),
  FOREIGN KEY (product_id) REFERENCES product(id)
);



INSERT into person (name) values('ivan');
INSERT into person (name) values('petr');

insert into product (name) values('product1');
insert into product (name) values('product1');
insert into product (name) values('product1');

insert into orders values(1, 1);
insert into orders values(1, 2);
insert into orders values(2, 3);
