-- 3. Did you know Eric Stoltz was originally cast as Marty McFly in "Back to the Future"? Add Eric Stoltz to the list of actors for "Back to the Future" (1 row)

INSERT INTO movie_actor (movie_id, actor_id)
SELECT m.movie_id, p.person_id
FROM movie m
JOIN person p ON m.title = 'Back to the Future'
WHERE p.person_name = 'Eric Stoltz';