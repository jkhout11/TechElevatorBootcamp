-- 4. Add a "Sports" genre to the genre table. Add the movie "Coach Carter" to the newly created genre. (1 row each)

INSERT INTO genre (genre_name)
VALUES ('Sports');


WITH sports_genre AS (
    SELECT genre_id
    FROM genre
    WHERE genre_name = 'Sports'
)

INSERT INTO movie_genre (movie_id, genre_id)
SELECT m.movie_id, g.genre_id
FROM movie m
CROSS JOIN sports_genre g
WHERE m.title = 'Coach Carter';

