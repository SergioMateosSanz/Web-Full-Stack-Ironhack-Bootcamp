DROP SCHEMA IF EXISTS lab708;
CREATE SCHEMA lab708;
USE lab708;

DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
    id INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    phone_number VARCHAR(255),
    office_number INT,
    position VARCHAR(255),
    manager VARCHAR(255)
);

INSERT INTO employees (name, phone_number, office_number, position, manager) VALUES
('Pepe García','+34 123456789',3 , "Director","himself"),
('Marta Sanz','+34 987654321',4 , "Sub-Director","Pepe García"),
('Juan Gómez','+34 333333333',5 , "Employee","Marta Sanz"),
('Nieves Pérez','+34 444444444',5 , "Employee","Marta Sanz")
;