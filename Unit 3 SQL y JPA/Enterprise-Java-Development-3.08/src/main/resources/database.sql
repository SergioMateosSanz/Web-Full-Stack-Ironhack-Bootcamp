DROP SCHEMA IF EXISTS lab308;
CREATE SCHEMA lab308;
USE lab308;

DROP TABLE IF EXISTS member;

CREATE TABLE member(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	status_member VARCHAR(255),
    renewal_date DATE,
    chapter INT,
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS chapter;

CREATE TABLE chapter(
	chapter_id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	district VARCHAR(255),
	president INT,
	PRIMARY KEY(chapter_id),
	FOREIGN KEY(president) REFERENCES member(id)
);



DROP TABLE IF EXISTS guest;

CREATE TABLE guest(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
	status_guest VARCHAR(255),
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS event;

CREATE TABLE event(
	id INT NOT NULL AUTO_INCREMENT,
    date_event DATE,
    duration TIME,
    location VARCHAR(255),
    title VARCHAR(255),
    type_event VARCHAR(255),
	PRIMARY KEY(id)
);

DROP TABLE IF EXISTS event_guests;

CREATE TABLE event_guests(
	event_id INT NOT NULL,
    guest_id INT NOT NULL,
    PRIMARY KEY (event_id,guest_id),
    FOREIGN KEY(event_id) REFERENCES event(id),
    FOREIGN KEY(guest_id) REFERENCES guest(id)
);

DROP TABLE IF EXISTS speaker;

CREATE TABLE speaker(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    presentation_duration TIME,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS event_speakers;

CREATE TABLE event_speakers(
	event_id INT NOT NULL,
    speaker_id INT NOT NULL,
    PRIMARY KEY (event_id,speaker_id),
    FOREIGN KEY(event_id) REFERENCES event(id),
    FOREIGN KEY(speaker_id) REFERENCES speaker(id)
);

