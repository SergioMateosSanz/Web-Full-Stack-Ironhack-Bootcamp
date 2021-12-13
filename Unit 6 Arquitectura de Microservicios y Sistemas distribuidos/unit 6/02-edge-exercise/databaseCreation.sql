DROP SCHEMA IF EXISTS lab603;
CREATE SCHEMA lab603;
USE lab603;

DROP TABLE IF EXISTS inventory;

CREATE TABLE inventory (
  serial_number BIGINT AUTO_INCREMENT NOT NULL,
  quantity INT ,
  PRIMARY KEY (serial_number)
);

INSERT INTO inventory (quantity) VALUES
(50),
(10),
(15);

DROP TABLE IF EXISTS price;

CREATE TABLE price (
  serial_number BIGINT AUTO_INCREMENT NOT NULL,
  product_name VARCHAR(255),
  price DOUBLE ,
  PRIMARY KEY (serial_number)
);

INSERT INTO price (product_name, price) VALUES
('shirt', 15.00),
('pants', 30.00),
('socks', 1.50);
