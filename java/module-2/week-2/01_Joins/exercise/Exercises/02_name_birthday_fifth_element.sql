-- 2. The names and birthdays of actors in "The Fifth Element"
-- Order the results alphabetically (A-Z) by name.
-- (15 rows)

SELECT p.person_name, p.birthday
	FROM person p
	JOIN movie_actor ma ON ma.actor_id = p.person_id
	JOIN movie m ON ma.movie_id = m.movie_id
	WHERE m.title = 'The Fifth Element'
	ORDER BY p.person_name;