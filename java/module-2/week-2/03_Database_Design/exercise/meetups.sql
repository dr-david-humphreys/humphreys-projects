CREATE TABLE member (
	member_number SERIAL PRIMARY KEY,
	last_name VARCHAR(50) NOT NULL,
	first_name VARCHAR(50) NOT NULL,
	email_address VARCHAR(100) NOT NULL UNIQUE,
	phone_number VARCHAR(15),
	date_of_birth DATE NOT NULL,
	reminder_email_flag BOOLEAN NOT NULL
);

CREATE TABLE interest_group (
	group_number SERIAL PRIMARY KEY,
	group_name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE event (
	event_number SERIAL PRIMARY KEY,
	event_name VARCHAR(100) NOT NULL,
	description TEXT,
	start_date_time TIMESTAMP NOT NULL,
	duration INTERVAL NOT NULL CHECK (duration >= INTERVAL '30 minutes'),
	group_number INTEGER,
	FOREIGN KEY (group_number) REFERENCES interest_group(group_number)
);

CREATE TABLE member_group (
	member_number INTEGER,
	group_number INTEGER,
	PRIMARY KEY (member_number, group_number),
	FOREIGN KEY (member_number) REFERENCES member(member_number),
	FOREIGN KEY (group_number) REFERENCES interest_group(group_number)
);

CREATE TABLE member_event (
	member_number INTEGER,
	event_number INTEGER,
	PRIMARY KEY (member_number, event_number),
	FOREIGN KEY (member_number) REFERENCES member(member_number),
	FOREIGN KEY (event_number) REFERENCES event(event_number)
);

INSERT INTO member (last_name, first_name, email_address, phone_number, date_of_birth, reminder_email_flag)
VALUES
	('Butler', 'Harvey', 'harvey.butler@meetups.com', '111-1111', '2000-01-01', TRUE),
	('Schneider', 'Adam', 'adam.schneider@meetups.com', '111-1112', '2000-01-02', FALSE),
	('Duffy', 'Lyla', 'lyla.duffy@meetups.com', '111-1113', '2000-01-03', TRUE),
	('Patel', 'Aaron', 'aaron.patel@meetups.com', '111-1114', '2000-01-04', FALSE),
	('Landry', 'Talha', 'talha.landry@meetups.com', '111-1115', '2000-01-05', TRUE),
	('Orr', 'Fred', 'fred.orr@meetups.com', '111-1116', '2000-01-06', FALSE),
	('Raymond', 'Faris', 'faris.raymond@meetups.com', '111-1117', '2000-01-07', TRUE),
	('Reeves', 'Simon', 'simon.reeves@meetups.com', '111-1118', '2000-01-08', FALSE);
	
INSERT INTO interest_group (group_name)
VALUES 
	('Book Club'),
	('Disc Golf Club'),
	('Rock Climbing Club');
	
INSERT INTO event (event_name, description, start_date_time, duration, group_number)
VALUES
	('Book Club Monthly Meetup', 'Discussing the book of the month and sharing insights.', '2023-07-20 18:00:00', INTERVAL '2 hours', 1),
	('Disc Golf Tournament', 'An exciting disc golf tournament with prizes for winners.', '2023-08-15 09:00:00', INTERVAL '5 hours', 2),
	('Rock Climbing Basics', 'A session on the basics of rock climbing for beginners.', '2023-09-05 10:00:00', INTERVAL '3 hours', 3),
	('Advanced Rock Climbing Techniques', 'A workshop for advanced rock climbing techniques and safety measures.', '2023-10-10 14:00:00', INTERVAL '4 hours', 3);