-- 1. The titles and release dates of movies that Tom Hanks has appeared in. 
-- Order the results by release date, newest to oldest.
-- (47 rows)

SELECT M.title,M.release_date
FROM movie M,person P,movie_actor A
WHERE P.person_name='Tom Hanks' AND A.actor_id=P.person_id AND M.movie_id=A.movie_id;