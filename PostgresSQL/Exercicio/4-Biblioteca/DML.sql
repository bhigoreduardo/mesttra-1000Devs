/* Insert aluno */
INSERT INTO aluno
	(nome, sobrenome, endereco, genero, data_nasc)
	VALUES
	('Caped',  'Baldy', 'Rua A, 1 - Cidade Z', 'M', '31-12-1970'),
	('Demon',  'Cyborg', 'Rua B, 1 - Cidade Z', 'M', '10-01-1972'),
	('Drive', 'Knight', 'Rua C, 1 - Cidade A', 'M', '13-05-1974'),
	('Watchdog', 'Man', 'Rua D, 1 - Cidade A', 'M', '16-08-1976'),
	('Metal', 'Bat', 'Rua E, 1 - Cidade A', 'M', '19-06-1978');

/* Insert autor */
INSERT INTO autor
	(nome, sobrenome, genero, data_nasc, cpf)
	VALUES
	('Sweet', 'Mask', 'M', '21-07-1981', '111.111.111-11'),
	('Blue', 'Fire', 'M', '24-08-1983', '222.222.222-22'),
	('Golden', 'Ball', 'M', '27-09-1985', '333.333.333-33'),
	('Doll', 'Master', 'M', '02-10-1987', '444.444.444-44'),
	('Mumen', 'Rider', 'M', '04-11-1989', '555.555.555-55');

/* Insert livro */
INSERT INTO livro
	(titulo, cod_autor)
	VALUES
	('Chainsaw Man', 1),
	('The Begging After the End', 2),
	('One Punch', 1),
	('Naruto', 3),
	('Pokemón', 4),
	('Jujutsu Kaisen', 5);

/* Insert emprestimo */
INSERT INTO emprestimo
	(cod_livro, matricula)
	VALUES
	(1, 1);
	
INSERT INTO emprestimo
	(cod_livro, matricula)
	VALUES
	(2, 1),
	(3, 1),
	(4, 1);
	
INSERT INTO emprestimo
	(cod_livro, matricula)
	VALUES
	(5, 2);

/* Update emprestimo */
UPDATE emprestimo
	SET devolucao = true
	WHERE cod_emprestimo = 1;

/* Consult database */
SELECT * FROM aluno ORDER BY matricula;
SELECT * FROM autor;
SELECT * FROM livro ORDER BY cod_livro;
SELECT * FROM emprestimo;

/*
a) 	Crie uma consulta que retorne a matricula, nome, sobrenome, gênero e a
quantidade de livros de todos os alunos.
*/
SELECT matricula, CONCAT(nome, ' ', sobrenome) AS aluno, genero, quant_livro
	FROM aluno;

/*
b)	 Crie uma consulta que retorne o nome, sobrenome e a quantidade de livros
cadastrada de cada autor ordenado por nome.
*/
SELECT CONCAT(a.nome, ' ', a.sobrenome) AS "autor", COUNT(*) AS livro
	FROM autor a INNER JOIN livro l
		ON a.cod_autor = l.cod_autor
	GROUP BY "autor";
	
/*	
c) 	Crie uma consulta que traga o nome, sobrenome e o endereço de todos os
alunos com mais de 3 livros emprestados.
*/
SELECT matricula, CONCAT(nome, ' ', sobrenome) AS aluno, endereco
	FROM aluno
	WHERE quant_livro > 3;

/*
d) 	Crie consultas para mostrar o autor com maior quantidade de livros e o que tem a menor quantidade.
*/
SELECT CONCAT(a.nome, ' ', a.sobrenome) AS "autor", COUNT(l.titulo) AS quantidade
	FROM autor a INNER JOIN livro l
		ON a.cod_autor = l.cod_autor
	GROUP BY "autor" ORDER BY quantidade DESC LIMIT 1

SELECT CONCAT(a.nome, ' ', a.sobrenome) AS "autor", COUNT(l.titulo) AS quantidade
	FROM autor a INNER JOIN livro l
		ON a.cod_autor = l.cod_autor
	GROUP BY "autor" ORDER BY quantidade ASC LIMIT 1

/*
e)	Crie uma consulta que traga o nome, sobrenome e a data de nascimento de
todos os alunos ordenados por data de nascimento do mais novo para o mais velho.
*/
SELECT CONCAT(nome, ' ', sobrenome) AS aluno, data_nasc
	FROM aluno
	ORDER BY data_nasc DESC;
	
/*	
f) 	Escreva o comando para atualizar o cadastro do aluno Metal Bat, alterando
o endereço para RUA A, Nº 1.
*/
UPDATE aluno
	SET endereco = 'RUA A, Nº 1'
	WHERE nome = 'Metal'
		AND sobrenome = 'Bat';


/*
g)	Crie uma consulta para retornar a quantidade de livros emprestados no mês de Outubro de 2022.
*/
SELECT l.titulo, e.data
	FROM livro l INNER JOIN emprestimo e
		ON l.cod_livro = e.cod_livro
	WHERE TO_CHAR(e.data, 'MM/YYYY') = '10/2022';

/*
h)	Crie uma consulta que traga o nome dos livros emprestados no ano de 2022 e quantas vezes cada um foi emprestado.
*/
SELECT l.titulo, COUNT(e.cod_livro)
	FROM livro l INNER JOIN emprestimo e
		ON l.cod_livro = e.cod_livro
	WHERE TO_CHAR(e.data, 'YYYY') = '2022'
	GROUP BY l.titulo;

/*
i)	Escreva o comando para atualizar o título do livro de: “Naruto” para “Naruto Shippuden”.
*/
UPDATE livro
	SET titulo = 'Naruto Shippuden'
	WHERE titulo = 'Naruto';

/*
j)    Crie uma VIEW nomeada “LIVROS_AUTOR_EMPRESTADOS” que traga o nome do livro,
o nome e sobrenome do autor, o genero do autor e a data de nascimento do autor
para todos os livros emprestados.
*/
CREATE VIEW vw_livro_autor_emprestado AS
	SELECT CONCAT(a.nome, ' ', a.sobrenome) AS autor, a.genero, a.data_nasc, l.titulo
		FROM autor a INNER JOIN livro l
			ON a.cod_autor = l.cod_autor
		WHERE l.status_emp = true;
		
SELECT * FROM vw_livro_autor_emprestado;

/* Exportar dados DML para CSV */
COPY aluno TO 'C:\bkp_aluno.csv' (DELIMITER ';', FORMAT CSV, NULL '',
								  ENCODING 'UTF-8', HEADER);

COPY
	( SELECT CONCAT(a.nome, ' ', a.sobrenome) AS aluno,
	  l.titulo AS livro
	  FROM aluno a INNER JOIN emprestimo e
	  	ON a.matricula = e.matricula INNER JOIN livro l
	 	ON l.cod_livro = e.cod_livro
	)
TO 'C:\bkp_emprestimo.csv' (DELIMITER ';', FORMAT CSV, NULL '',
								  ENCODING 'UTF-8', HEADER);

/* Importar dados CSV para DML */
COPY aluno (matricula, nome, sobrenome, endereco, genero, data_nasc, quant_livro) FROM
'C:\bkp_aluno.csv' (DELIMITER ';', FORMAT CSV, NULL '',
					ENCODING 'UTF-8', HEADER);