INSERT INTO music_piece (title, composer, arranger, genre, duration) VALUES
('Symphony No. 5', 'Ludwig van Beethoven', NULL, 'Classical', 3300),
('Clair de Lune', 'Claude Debussy', NULL, 'Impressionism', 300),
('The Entertainer', 'Scott Joplin', NULL, 'Ragtime', 200),
('Nocturne Op. 9 No. 2', 'Frédéric Chopin', NULL, 'Romantic', 240);

INSERT INTO practice_session (user_id, date, duration, pieces_practiced, notes) VALUES
(1, '2024-07-30', 60, 'Symphony No. 5, Clair de Lune', 'Felt good about the progress.'),
(2, '2024-07-29', 45, 'The Entertainer', 'Need to work on timing.'),
(1, '2024-07-28', 30, 'Nocturne Op. 9 No. 2', 'Practice the phrasing.'),
(2, '2024-07-27', 50, 'Clair de Lune, The Entertainer', 'Great session with both pieces.');

INSERT INTO goal (user_id, description, target_date, achieved, notes) VALUES
(1, 'Master Symphony No. 5', '2024-12-31', FALSE, 'Focus on the final movement.'),
(2, 'Improve sight-reading skills', '2024-09-30', TRUE, 'Significant improvement over the last few months.'),
(1, 'Complete learning Clair de Lune', '2024-11-15', FALSE, 'Currently halfway through.'),
(2, 'Perform The Entertainer perfectly', '2024-08-15', FALSE, 'Working on the tempo.');

INSERT INTO practice_session_music_piece (practice_session_id, music_piece_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 4),
(4, 2),
(4, 3);