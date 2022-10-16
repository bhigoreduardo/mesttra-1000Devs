/* SELECT table_name */
SELECT table_name
	FROM information_schema.tables
	WHERE table_schema = 'public'
	ORDER BY table_name;

SELECT *
	FROM fruta_a;

/* INNER JOIN */
SELECT *
	FROM fruta_a
	INNER JOIN fruta_b
	ON fruta_a.nome = fruta_b.nome;
	
SELECT *
	FROM fruta_a, fruta_b
	WHERE fruta_a.nome = fruta_b.nome;
	
SELECT *
	FROM fruta_a
	INNER JOIN fruta_b
	ON fruta_a.nome = fruta_b.nome
	AND fruta_a.nome LIKE 'G%';
	
/* LEFT JOIN e LEFT OUTER JOIN */
SELECT *
	FROM fruta_a
	LEFT JOIN fruta_b
	ON fruta_a.nome = fruta_b.nome;
	
SELECT *
	FROM fruta_a
	LEFT OUTER JOIN fruta_b
	ON fruta_a.nome = fruta_b.nome;

SELECT *
	FROM fruta_a
	LEFT JOIN fruta_b
	ON fruta_a.nome = fruta_b.nome
	WHERE fruta_b.nome IS NULL;
	
/* RIGHT JOIN e RIGHT OUTER JOIN */
SELECT *
	FROM fruta_a
	RIGHT JOIN fruta_b
	ON fruta_a.nome = fruta_b.nome;
	
SELECT *
	FROM fruta_a
	RIGHT OUTER JOIN fruta_b
	ON fruta_a.nome = fruta_b.nome;

SELECT *
	FROM fruta_a
	RIGHT JOIN fruta_b
	ON fruta_a.nome = fruta_b.nome
	WHERE fruta_a.nome IS NULL;
	
/* FULL JOIN */
SELECT *
	FROM fruta_a
	FULL JOIN fruta_b
	ON fruta_a.nome = fruta_b.nome;

SELECT *
	FROM fruta_a
	FULL OUTER JOIN fruta_b
	ON fruta_a.nome = fruta_b.nome;
	
SELECT *
	FROM fruta_a
	FULL JOIN fruta_b
	ON fruta_a.nome = fruta_b.nome
	WHERE fruta_a.nome IS NULL OR fruta_b.nome IS NULL;
	
/* NATURAL JOIN */
SELECT *
	FROM fruta_a
	NATURAL JOIN fruta_b;