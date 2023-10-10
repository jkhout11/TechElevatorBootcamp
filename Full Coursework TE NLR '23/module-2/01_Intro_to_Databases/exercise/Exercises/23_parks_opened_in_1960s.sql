-- 23. The name and date established of parks opened in the 1960s (6 rows)
	SELECT
  park_name,
  date_established
FROM
  park
WHERE
  date_part('year', date_established) >= 1960
  AND date_part('year', date_established) < 1970;
