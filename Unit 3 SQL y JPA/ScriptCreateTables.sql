DROP SCHEMA IF EXISTS demo;
CREATE SCHEMA demo;
USE demo;

DROP TABLE IF EXISTS product;

CREATE TABLE product (
  id BIGINT AUTO_INCREMENT NOT NULL,
  name VARCHAR(255),
  price DECIMAL(10,2),
  category VARCHAR(30),
  department VARCHAR(30),
  PRIMARY KEY (id)
);

INSERT INTO product (name, price, category, department) VALUES
('Diamond Necklace', 750.49, 'COMMERCIAL_NEW', 'JEWELRY'),
('Pooka Shell Bracelet', 7.50, 'HANDMADE', 'JEWELRY'),
('Commodore 64', 225.00, 'COMMERCIAL_USED', 'ELECTRONICS'),
('Baby Blue Tuxedo', 65.25, 'COMMERCIAL_USED', 'CLOTHING'),
('Rectangular Persian Rug', 7500.00, 'HANDMADE', 'HOMEGOODS');

DROP TABLE IF EXISTS course;

CREATE TABLE course(
	course_code VARCHAR(6) NOT NULL,
	course_name VARCHAR(255),
	PRIMARY KEY(course_code)
);

DROP TABLE IF EXISTS section;

CREATE TABLE section(
	id VARCHAR(8) NOT NULL,
    course_code VARCHAR(6),
    room_number SMALLINT,
    professor VARCHAR(255),
    PRIMARY KEY(id),
    FOREIGN KEY(course_code) REFERENCES course(course_code)
);

DROP TABLE IF EXISTS grade;

CREATE TABLE grade(
	id INT NOT NULL AUTO_INCREMENT,
    student_name VARCHAR(255),
    section_id VARCHAR(8),
    score TINYINT,
    PRIMARY KEY(id),
    FOREIGN KEY(section_id) REFERENCES section(id)
);

DROP TABLE IF EXISTS song_table;

CREATE TABLE song_table(
	id BIGINT NOT NULL AUTO_INCREMENT,
    song_title VARCHAR(255),
    song_album VARCHAR(255),
    artist_name VARCHAR(255),
    PRIMARY KEY(id)
);

DROP SCHEMA IF EXISTS demo_test;
CREATE SCHEMA demo_test;
USE demo_test;

DROP TABLE IF EXISTS song_table;

CREATE TABLE song_table(
	id BIGINT NOT NULL AUTO_INCREMENT,
    song_title VARCHAR(255),
    song_album VARCHAR(255),
    artist VARCHAR(255),
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS course;

CREATE TABLE course(
	course_code VARCHAR(6) NOT NULL,
	course_name VARCHAR(255),
	PRIMARY KEY(course_code)
);

DROP TABLE IF EXISTS section;

CREATE TABLE section(
	id VARCHAR(8) NOT NULL,
    course_code VARCHAR(6),
    room_number SMALLINT,
    professor VARCHAR(255),
    PRIMARY KEY(id),
    FOREIGN KEY(course_code) REFERENCES course(course_code)
);

DROP TABLE IF EXISTS grade;

CREATE TABLE grade(
	id INT NOT NULL AUTO_INCREMENT,
    student_name VARCHAR(255),
    section_id VARCHAR(8),
    score TINYINT,
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);

DROP TABLE IF EXISTS role;

CREATE TABLE role (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user (id)
);

INSERT INTO user (username, password) VALUES
("user", "$2a$10$MSzkrmfd5ZTipY0XkuCbAejBC9g74MAg2wrkeu8/m1wQGXDihaX3e"),
("technician", "$2a$10$MSzkrmfd5ZTipY0XkuCbAejBC9g74MAg2wrkeu8/m1wQGXDihaX3e"),
("admin","$2a$10$MSzkrmfd5ZTipY0XkuCbAejBC9g74MAg2wrkeu8/m1wQGXDihaX3e");

INSERT INTO role (name, user_id) VALUES
("TECHNICIAN", 2),
("ADMIN", 3),
("TECHNICIAN", 3);


DROP TABLE IF EXISTS department_garden;

CREATE TABLE department_garden (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    department VARCHAR(255)
);

DROP TABLE IF EXISTS product_garden;

CREATE TABLE product_garden (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	department_id INT,
    name VARCHAR(255),
    quantity INT,
    FOREIGN KEY (department_id) REFERENCES department_garden (id)
);

INSERT INTO department_garden (department) VALUES
("tools"),("edible plants"),("non-edible plants"),("edible seeds"),("non-edible seeds"),("miscellaneus");

INSERT INTO product_garden (department_id, name, quantity) VALUES
(1,"small shovel", 50),
(1,"large shovel", 150),
(2,"apple tree sapling", 10),
(4,"assorted root vegetable seed packet", 2000),
(5,"geranium seed packet", 1000),
(2,"sprouted carrots", 200),
(6,"large brim gardering hat", 25);
