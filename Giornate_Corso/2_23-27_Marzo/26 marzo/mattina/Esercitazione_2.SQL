--Esercizio 1
SELECT ci.Name AS city, 
       co.Name AS country, 
       cl.Language
FROM ((city AS ci
       INNER JOIN country AS co 
       ON ci.CountryCode = co.Code)
      INNER JOIN countrylanguage AS cl 
      ON co.Code = cl.CountryCode);

--Esercizio 2
SELECT co.Name AS country, 
       COUNT(ci.ID) as Num_city
FROM country AS co
INNER join city AS ci
	ON co.Code = ci.CountryCode
GROUP BY co.Code
ORDER BY Num_city DESC;

--Esercizio 3
SELECT co.name AS country, 
       co.LifeExpectancy, 
       cl.Language
FROM country AS co
INNER JOIN countrylanguage AS cl 
       ON co.Code = cl.CountryCode
WHERE co.GovernmentForm LIKE "%republic%"
AND co.LifeExpectancy > 70;

--Esercizio 4
SELECT ci.Name AS city, 
       ci.Population
FROM city AS ci
WHERE ci.Population > 5000000

UNION

SELECT ci.Name as City,
        ci.Population
FROM city AS ci
INNER JOIN country AS co
	ON ci.ID = co.Capital
WHERE co.Capital IS NOT NULL; 
--giusto per paesi senza capitale (Antartide)
--è vero anche che per 5mln+ città è poco probabile che non sia una capitale 

--Esercizio 5
SELECT co.Name AS country,
	cl.Language,
    cl.Percentage
FROM country AS co 
JOIN countrylanguage AS cl ON co.Code = cl.CountryCode;

--Esercizio 6
SELECT co.Name AS country,
	cl.Language AS Most_spoken_language,
    MAX(cl.Percentage)
FROM country AS co 
JOIN countrylanguage AS cl ON co.Code = cl.CountryCode
GROUP BY co.Name;

--Esercizio 7
SELECT co.Name AS country,
	cl.Language,
   cl.Percentage
FROM country AS co 
JOIN countrylanguage AS cl ON co.Code = cl.CountryCode
WHERE cl.Percentage = 100 AND cl.IsOfficial = "T"
GROUP BY co.Name;

--Esercizio 8
SELECT co.Name as country,
	CASE
    	WHEN co.SurfaceArea >= 100000 THEN "True"
        ELSE "False"
        END AS Surface_area_more_than_10e5,
IFNULL(co.IndepYear, 'Anno non presente') AS Independence_year
FROM country AS co;

--Esercizio 9
SET @countryCode = 'NLD';
SET @minPopulation = 100000;
SET @orderDesc = TRUE;

SELECT ci.Name AS city,
	ci.Population, 
    ci.CountryCode,
    CASE 
    	WHEN TRUE THEN co.Name ELSE NULL END AS country
FROM city AS ci
LEFT JOIN country AS co 
	ON ci.CountryCode = co.Code
WHERE ci.CountryCode = @countryCode AND ci.Population >= @minPopulation
ORDER BY CASE WHEN @orderDesc THEN ci.Population END DESC,
         CASE WHEN NOT @orderDesc THEN ci.Population END ASC;

--Esercizio 10
--prima creo la VIEW di città_italiane
CREATE VIEW città_italiane AS
SELECT ci.Name AS Città,
	ci.Population AS Popolazione,
    ci.District AS Regione
FROM city ci
WHERE ci.CountryCode = 'ITA';
--Qui mostro la tabella, con la condizione che population sia minore di 100k
SELECT *
FROM città_italiane
WHERE Population < 100000;

--ALTERNATIVO USANDO WITH

WITH citta_italiane AS (
    SELECT ci.Name AS città, 
       ci.Population AS Popolazione,
       ci.District AS Regione
    FROM city ci
    WHERE ci.CountryCode = 'ITA'
)
SELECT *
FROM citta_italiane
WHERE Population < 100000;