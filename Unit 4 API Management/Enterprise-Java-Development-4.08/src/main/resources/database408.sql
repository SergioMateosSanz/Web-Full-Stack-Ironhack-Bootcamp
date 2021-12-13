DROP SCHEMA IF EXISTS lab408;
CREATE SCHEMA lab408;
USE lab408;

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
("admin","$2a$10$MSzkrmfd5ZTipY0XkuCbAejBC9g74MAg2wrkeu8/m1wQGXDihaX3e"),
("contributor","$2a$10$MSzkrmfd5ZTipY0XkuCbAejBC9g74MAg2wrkeu8/m1wQGXDihaX3e");

INSERT INTO role (name, user_id) VALUES
("TECHNICIAN", 2),
("ADMIN", 3),
("TECHNICIAN", 3),
("CONTRIBUTOR", 4);

DROP TABLE IF EXISTS author;

CREATE TABLE author (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(255)
);

INSERT INTO author (name) VALUES
("Aiko Tanaka"),
("Jona Schmidt"),
("Cas Van Dijk");

DROP TABLE IF EXISTS post;

CREATE TABLE post (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    author_id INT,
    title VARCHAR(255),
    post VARCHAR(255),
	FOREIGN KEY (author_id) REFERENCES author (id)
);

INSERT INTO post (author_id, title, post) VALUES
(1, "Boost Your Productivity with 10 Easy Tips", "Productivity - we all want it but it seems ..."),
(1, "How to Focus", "Do you ever sit down to work and find yourself ..."),
(2, "Learn to Speed Read in 30 Days", "Knowledge, not ability, is the great determiner of ...");