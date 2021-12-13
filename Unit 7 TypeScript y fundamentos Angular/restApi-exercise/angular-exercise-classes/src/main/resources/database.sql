DROP SCHEMA IF EXISTS angularAPIconection;
CREATE SCHEMA angularAPIconection;
USE angularAPIconection;

DROP TABLE IF EXISTS classes;

CREATE TABLE classes(
	id INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(255),
	description VARCHAR(255),
	PRIMARY KEY(id)
);

INSERT INTO classes(title, description) VALUES
('Literature','the best expression of the best thought reduced to writing '),
('Algebra','mathematical structure'),
('Algebra II','mathematical structure advance'),
('Geometry','models the space of the physical world'),
('Statistics','collection, organization, analysis, interpretation, and presentation of data'),
('Trigonometry','Math'),
('Calculus','relationships between side lengths and angles of triangles'),
('Biology','study of life'),
('Chemistry','study of the properties and behavior of matter'),
('Physics','studies matter,its fundamental constituents, its motion and behavior through space and time');