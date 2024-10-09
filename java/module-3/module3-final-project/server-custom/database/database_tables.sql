CREATE TABLE practice_session (
	practice_session_id SERIAL PRIMARY KEY,
	user_id INTEGER,
	date DATE NOT NULL,
	duration INTEGER NOT NULL,
	pieces_practiced VARCHAR(1000),
	notes VARCHAR(1000),
	FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE goal (
	goal_id SERIAL PRIMARY KEY,
	user_id INTEGER NOT NULL,
	description VARCHAR(100) NOT NULL,
	target_date DATE NOT NULL,
	achieved BOOLEAN NOT NULL DEFAULT FALSE,
	notes VARCHAR(1000),
	FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE music_piece (
	music_piece_id SERIAL PRIMARY KEY,
	title VARCHAR(100) NOT NULL,
	composer VARCHAR(100) NOT NULL,
	arranger VARCHAR(100),
	genre VARCHAR(100),
	duration INTEGER
);

CREATE TABLE practice_session_music_piece (
	practice_session_id INTEGER,
	music_piece_id INTEGER,
	PRIMARY KEY (practice_session_id, music_piece_id),
	FOREIGN KEY (practice_session_id) REFERENCES practice_session(practice_session_id),
	FOREIGN KEY (music_piece_id) REFERENCES music_piece(music_piece_id)
);