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