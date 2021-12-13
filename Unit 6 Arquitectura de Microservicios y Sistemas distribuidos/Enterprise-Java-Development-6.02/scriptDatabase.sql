DROP SCHEMA IF EXISTS lab602;
CREATE SCHEMA lab602;
USE lab602;

DROP TABLE IF EXISTS book;

CREATE TABLE book (
  isbn VARCHAR(13) NOT NULL,
  title VARCHAR(255),
  author VARCHAR(255),
  genre VARCHAR(255),
  PRIMARY KEY (isbn)
);

DROP TABLE IF EXISTS format;

CREATE TABLE format (
  id SMALLINT UNSIGNED AUTO_INCREMENT NOT NULL,
  name VARCHAR(255),
  PRIMARY KEY (id)
);

INSERT INTO format (name) VALUES
('hardcover'),
('paperback'),
('electronic'),
('audio');

DROP TABLE IF EXISTS book_format;

CREATE TABLE book_format (
  isbn VARCHAR(13) NOT NULL,
  id SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY (isbn,id),
  FOREIGN KEY (isbn) REFERENCES book (isbn),
  FOREIGN KEY (id) REFERENCES format (id)
);