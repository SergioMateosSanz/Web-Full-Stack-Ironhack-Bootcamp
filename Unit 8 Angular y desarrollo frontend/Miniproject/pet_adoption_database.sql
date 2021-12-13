DROP SCHEMA IF EXISTS pet_database;
CREATE SCHEMA pet_database;
USE pet_database;

DROP SCHEMA IF EXISTS pet_database_test;
CREATE SCHEMA pet_database_test;



CREATE TABLE animal(
	id BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255),
    `type` VARCHAR(50),
    age INT,
    available BOOLEAN,
    PRIMARY KEY(id)
);

CREATE TABLE adopter(
	id BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255),
    pet BIGINT,
    PRIMARY KEY(id),
    UNIQUE (`name`),
    FOREIGN KEY (pet) REFERENCES animal(id)
);

insert into animal(name, type, age, available) VALUES
('Perro1', 'DOG', 2, TRUE),
('Perro2', 'DOG', 4, TRUE),
('Perro3', 'DOG', 5, FALSE),
('Perro4', 'DOG', 1, FALSE),
('Gato1', 'CAT', 2, TRUE),
('Gato2', 'CAT', 4, TRUE),
('Gato3', 'CAT', 5, FALSE),
('Gato4', 'CAT', 1, FALSE);

insert into adopter(name, pet) VALUES
('Adopter1', 3),
('Adopter2', 4),
('Adopter3', 7),
('Adopter4', 8);


select * from animal;
select * from adopter;