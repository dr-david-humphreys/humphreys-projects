-- 13. The directors of the movies in the "Harry Potter Collection", sorted alphabetically.
-- (4 rows)

SELECT DISTINCT p.person_name
	FROM person p
	JOIN movie m ON p.person_id = m.director_id
	JOIN collection c ON m.collection_id = c.collection_id
	WHERE c.collection_name = 'Harry Potter Collection'
	ORDER BY p.person_name;