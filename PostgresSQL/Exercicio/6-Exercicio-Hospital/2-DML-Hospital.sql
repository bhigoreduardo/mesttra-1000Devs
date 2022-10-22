/* Insert enfermidade */
INSERT INTO enfermidade VALUES
(1, 'Gripe'),
(2, 'Dengue'),
(3, 'Caxumba'),
(4, 'Virose'),
(5, 'Pneumonia');

/* Insert quarto */
INSERT INTO quarto VALUES
(1, 100, 1),
(2, 101, 1),
(3, 102, 1),
(4, 103, 1),
(5, 104, 1),
(6, 200, 2),
(7, 201, 2),
(8, 202, 2),
(9, 203, 2),
(10, 204, 2);

/* Insert medico */
INSERT INTO medico VALUES
(1, 'Drive', 'Knight', 'Cidade A, 1', 'F', '123456789', 'Cardiologista', 12000.00), 
(2, 'Flashy', 'Flash', 'Cidade B, 2', 'M', '123456770', 'Urologista', 11500.00),
(3, 'Watchdog', 'Man', 'Cidade A, 3', 'M', '123456780', 'Pediatra', 10000.00),
(4, 'Metal', 'Bat', 'Cidade D, 4', 'M', '123456760', 'Clinico Geral', 9000.00),
(5, 'Demon', 'Cyborg', 'Cidade Z, 5', 'M', '123456750', 'Cardiologista', 12000.00);

/* Insert paciente */
INSERT INTO paciente VALUES
(1, 'Sweet', 'Mask', 'Cidade F, 6', 'M', '01-02-1986', 1, 1),
(2, 'Death', 'Gatling', 'Cidade G, 7', 'M', '02-01-1984', 2, 1),
(3, 'Twin', 'Tail', 'Cidade H, 8', 'F', '15-12-1984', 3, 2),
(4, 'Shadow', 'Ring', 'Cidade I, 9', 'M', '22-06-1985', 4, 2),
(5, 'Blizzard', 'of Heel', 'Cidade J, 10', 'F', '19-03-1987', 5, 3),
(6, 'Caped', 'Baldy', 'Cidade A, 11', 'M', '30-07-1988', 6, 3),
(7, 'Captain', 'Mizuki', 'Cidade L, 12', 'F', '09-09-1990', 7, 4),
(8, 'Darkness', 'Blade', 'Cidade M, 13', 'M', '12-10-1989', 8, 4),
(9, 'Mumen', 'Rider', 'Cidade N, 14', 'M', '02-04-1991', 9, 5),
(10, 'Silver', 'Fang', 'Cidade O, 15', 'M', '03-11-1982', 10, 5);

/* Insert enfermidade-paciente */
INSERT INTO enfermidade_paciente VALUES
(1, 1, 1, '01-09-2015'),
(2, 2, 2, '02-09-2015'),
(3, 3, 3, '03-09-2015'),
(4, 4, 4, '04-09-2015'),
(5, 5, 5, '05-09-2015'),
(6, 6, 1, '06-09-2015'),
(7, 7, 2, '07-09-2015'),
(8, 8, 3, '08-09-2015'),
(9, 9, 4, '09-09-2015'),
(10, 10, 5, '10-09-2015');

/* a) 	Crie uma consulta que retorne o código, nome, sobrenome, 
numero_crm e especialidade de todos os médicos. */
SELECT CONCAT(nome, ' ', sobrenome) AS medico, numero_crm, especialidade
	FROM medico;

/* b)	 Crie uma consulta que retorne o nome, sobrenome e
 o numero_crm de todos os médicos ordenados por nome. */
SELECT CONCAT(nome, ' ', sobrenome) AS medico, numero_crm, especialidade
	FROM medico
	ORDER BY nome;

/* c) 	Crie uma consulta que traga o nome, sobrenome 
e o endereço de todos os pacientes que são do gênero masculino. */
SELECT CONCAT(nome, ' ', sobrenome) as paciente, endereco
	FROM paciente
	WHERE genero = 'M';

/* d) 	Crie uma consulta para mostrar o nome 
e o sobrenome de todos os pacientes do médico chamado Drive Knight. */
SELECT CONCAT(p.nome, ' ', p.sobrenome) AS paciente, CONCAT(m.nome, ' ', m.sobrenome) AS medico
	FROM paciente p INNER JOIN medico m
		ON p.cod_medico = m.cod_medico
	WHERE m.nome = 'Drive' AND m.sobrenome = 'Knight';

SELECT CONCAT(p.nome, ' ', p.sobrenome) AS paciente, CONCAT(m.nome, ' ', m.sobrenome) AS medico
	FROM paciente p, medico m
	WHERE p.cod_medico = m.cod_medico
		AND m.nome = 'Drive'
		AND m.sobrenome = 'Knight';

/* e)	Crie uma consulta que traga o nome, sobrenome 
e a data de nascimento de todos os pacientes ordenados 
por data de nascimento do mais novo para o mais velho. */
SELECT CONCAT(nome, ' ', sobrenome) AS paciente, data_nasc
	FROM paciente
	ORDER BY data_nasc DESC;

/* f)	Crie uma consulta que mostre quais as enfermidades 
(nome da doença) do paciente mais novo. */
SELECT CONCAT(p.nome, ' ', p.sobrenome) AS paciente, p.data_nasc, e.descricao
	FROM enfermidade e INNER JOIN enfermidade_paciente ep
		ON e.cod_enf = ep.cod_enf INNER JOIN paciente p
		ON ep.cod_paciente = p.cod_paciente
	WHERE p.data_nasc = ( SELECT MAX(data_nasc)
						  FROM paciente );
						  
SELECT CONCAT(p.nome, ' ', p.sobrenome) AS paciente, p.data_nasc, e.descricao
	FROM enfermidade e, enfermidade_paciente ep, paciente p
	WHERE e.cod_enf = ep.cod_enf
		AND ep.cod_paciente = p.cod_paciente
		AND p.data_nasc = ( SELECT MAX(data_nasc)
						  FROM paciente );

/* g)	Crie uma consulta para retornar a quantidade de quartos
 no 1º Andar. */
SELECT COUNT(*)
	FROM quarto
	WHERE andar = 1;

/* h)	Crie uma consulta que traga a média de salário de todos 
os médicos. */
SELECT AVG(salario)::MONEY
	FROM medico;

/* i)	Crie uma consulta para mostrar a quantidade de médicos 
 em cada especialidade. */
SELECT especialidade, COUNT(*) AS total
	FROM medico
	GROUP BY especialidade
	ORDER BY total DESC;
	
SELECT DISTINCT especialidade
	FROM medico;

/* j)	Crie uma consulta que retorne o nome do paciente, 
sobrenome, nome do médico,  sobrenome e o quarto  dos pacientes 
que estão com a enfermidade DENGUE. */
SELECT CONCAT(p.nome, ' ', p.sobrenome) AS paciente,
	   CONCAT(m.nome, ' ', m.sobrenome) AS medico,
	   q.numero, e.descricao
   	FROM paciente p INNER JOIN medico m
		ON p.cod_medico = m.cod_medico INNER JOIN quarto q
		ON p.cod_quart = q.cod_quart INNER JOIN enfermidade_paciente ep
		ON p.cod_paciente = ep.cod_paciente INNER JOIN enfermidade e
		ON e.cod_enf = ep.cod_enf
	WHERE e.descricao = 'Dengue';
		
SELECT CONCAT(p.nome, ' ', p.sobrenome) AS paciente,
	   CONCAT(m.nome, ' ', m.sobrenome) AS medico,
	   q.numero, e.descricao
   	FROM paciente p, medico m, quarto q, enfermidade_paciente ep, enfermidade e
	WHERE p.cod_medico = m.cod_medico
		AND p.cod_quart = q.cod_quart
		AND p.cod_paciente = ep.cod_paciente 
		AND e.cod_enf = ep.cod_enf
		AND e.descricao = 'Dengue';

/* Criação de View */
CREATE VIEW vw_paciente_medico_dengue AS
	SELECT CONCAT(p.nome, ' ', p.sobrenome) AS paciente,
	   CONCAT(m.nome, ' ', m.sobrenome) AS medico,
	   q.numero, e.descricao
   	FROM paciente p, medico m, quarto q, enfermidade_paciente ep, enfermidade e
	WHERE p.cod_medico = m.cod_medico
		AND p.cod_quart = q.cod_quart
		AND p.cod_paciente = ep.cod_paciente 
		AND e.cod_enf = ep.cod_enf
		AND e.descricao = 'Dengue';
			
SELECT * FROM vw_paciente_medico_dengue;