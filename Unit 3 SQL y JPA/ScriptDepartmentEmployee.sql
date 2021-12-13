CREATE TABLE department(
	id INT NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY(id)
);
CREATE TABLE employee(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    department_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(department_id) REFERENCES department(id)
);
INSERT INTO department(id, name) VALUES
	(31, 'Sales'),
    (33, 'Engineering'),
    (34, 'Clerical'),
    (35, 'Marketing')
;
INSERT INTO employee (name, department_id) VALUES
	('Rafferty', 31),
    ('Jones', 33),
    ('Heisenberg', 33),
    ('Robinson', 34),
    ('Smith', 34),
    ('Williams', NULL)
; 