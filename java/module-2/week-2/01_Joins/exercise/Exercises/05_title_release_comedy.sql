-- 5. The titles and release dates of all the movies that are in the Comedy genre.
-- Order the results by release date, earliest to latest.
-- (220 rows)

SELECT m.title, m.release_date
	FROM movie m
	JOIN movie_genre mg ON m.movie_id = mg.movie_id
	JOIN genre g ON mg.genre_id = g.genre_id
	WHERE g.genre_name = 'Comedy'
	ORDER BY m.release_date;