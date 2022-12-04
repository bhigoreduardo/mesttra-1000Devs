/* Insert departamento */
INSERT INTO departamento (codigo, nome, localizacao) VALUES
(1, 'Financeiro', '4º Andar'),
(2, 'Departamento Pessoal', '3º Andar'),
(3, 'TI', '2º Andar'),
(4, 'Vendas', '1º Andar');

/* Insert funcionario */
INSERT INTO funcionario VALUES
(1, 'Caped',  'Baldy', '31-12-1970', '111.111.111-11', '12345678', 'Rua A, 1', '12345678', 'Cidade Z', 'CZ', '64-3430-0001', 'Aux. Adm', 980.00, 1),
(2, 'Demon',  'Cyborg', '10-01-1972', '222.222.222-22', '12345678', 'Rua B, 1', '12345678', 'Cidade Z', 'CZ', '64-3430-0002', 'Telefonista', 980.00, 1),
(3, 'Drive', 'Knight', '13-05-1974', '333.333.333-33', '12345678', 'Rua C, 1', '12345678', 'Cidade A', 'CA', '64-3430-0003', 'Aux. Adm', 980.00, 1),
(4, 'Watchdog', 'Man', '16-08-1976', '444.444.444-44', '12345678', 'Rua D, 1', '12345678', 'Cidade A', 'CA', '64-3430-0004', 'Aux. Adm', 2000.00, 2),
(5, 'Metal', 'Bat', '19-06-1978', '555.555.555-55', '12345678', 'Rua E, 1', '12345678', 'Cidade A', 'CA', '64-3430-0005', 'Analista de Sistemas', 10000.00, 3),
(6, 'Sweet', 'Mask', '21-07-1981', '666.666.666-66', '12345678', 'Rua F, 1', '12345678', 'Cidade A', 'CA', '64-3430-0006', 'Vendedor', 3000.00, 4),
(7, 'Blue', 'Fire', '24-08-1983', '777.777.777-77', '12345678', 'Rua G, 1', '12345678', 'Cidade B', 'CB', '64-3430-0007', 'Supervisor', 9000.00, 1),
(8, 'Golden', 'Ball', '27-09-1985', '888.888.888-88', '12345678', 'Rua H, 1', '12345678', 'Cidade B', 'CB', '64-3430-0008', 'Supervisor', 9000.00, 2),
(9, 'Doll', 'Master', '02-10-1987', '999.999.999-99', '12345678', 'Rua I, 1', '12345678', 'Cidade B', 'CB', '64-3430-0009', 'Supervisor', 9000.00, 3),
(10, 'Mumen', 'Rider', '04-11-1989', '111.111.111-20', '12345678', 'Rua J, 1', '12345678', 'Cidade C', 'CC', '64-3430-0010', 'Supervisor', 9000.00, 4);

UPDATE departamento SET cod_func_gerente = 7 WHERE codigo = 1;
UPDATE departamento SET cod_func_gerente = 8 WHERE codigo = 2;
UPDATE departamento SET cod_func_gerente = 9 WHERE codigo = 3;
UPDATE departamento SET cod_func_gerente = 10 WHERE codigo = 4;

/* 01 - Listar nome e Sobrenome de Funcionários ordenado por sobrenome. */
SELECT CONCAT(nome, ' ', sobrenome) AS funcionario
	FROM funcionario
	ORDER BY sobrenome;
	
/* 02 - Listar todos os campos de Funcionários ordenados por cidade. */
SELECT *
	FROM funcionario
	ORDER BY cidade;
	
/* 03 - Liste os funcionários que têm salário superior a R$ 1.000,00 ordenados pelo nome completo. */
SELECT *
	FROM funcionario
	WHERE salario > 1000
	ORDER BY nome, sobrenome;
	
/* 04 - Liste a data de nascimento e o primeiro nome dos 
funcionários ordenados do mais novo para o mais velho. */
SELECT nome, datanasci
	FROM funcionario
	ORDER BY datanasci DESC;
	
/* 05 - Liste os funcionários como uma lista telefônica 
(Nome, SobreNome, Fone, Endereço, Cidade, UF). */
SELECT nome, sobrenome, fone, endereco, cidade, uf
	FROM funcionario;
	
/* 06 - Liste o total da folha de pagamento. */
SELECT SUM(salario)::MONEY
	FROM funcionario;
	
/* 07 - Liste o nome, Sobrenome, Nome do Departamento 
e a função de todos os funcionários. */
SELECT CONCAT(f.nome, ' ', f.sobrenome) AS funcionario, d.nome AS departamento, f.funcao
	FROM funcionario f INNER JOIN departamento d
		ON f.codigodepartamento = d.codigo;
		
SELECT CONCAT(f.nome, ' ', f.sobrenome) AS funcionario, d.nome AS departamento, f.funcao
	FROM funcionario f, departamento d
	WHERE f.codigodepartamento = d.codigo;
	
/* 08 - Liste todos os departamentos com seus respectivos gerentes. */
SELECT d.nome AS departamento, CONCAT(f.nome, ' ', f.sobrenome) AS gerente
	FROM departamento d INNER JOIN funcionario f
		ON d.cod_func_gerente = f.codigo;
		
SELECT d.nome AS departamento, CONCAT(f.nome, ' ', f.sobrenome) AS gerente
	FROM departamento d, funcionario f
	WHERE d.cod_func_gerente = f.codigo;
	
/* 09 - Liste o valor da folha de pagamento de cada departamento,
 ordenado pelo nome do departamento. */
SELECT d.nome AS dapartamento, SUM(f.salario)::MONEY AS salario
	FROM departamento d INNER JOIN funcionario f
		ON d.codigo = f.codigodepartamento
	GROUP BY d.nome;
	
SELECT d.nome AS dapartamento, SUM(f.salario)::MONEY AS salario
	FROM departamento d, funcionario f
	WHERE d.codigo = f.codigodepartamento
	GROUP BY d.nome;
	
/* 10 - Liste os departamentos dos funcionários que têm a função
 de Supervisor. */
SELECT *
	FROM funcionario
	WHERE funcao = 'Supervisor';
	
/* 11 - Liste a quantidade de funcionários desta empresa. */
SELECT COUNT(*) AS total
	FROM funcionario;
	
/* 12 - Liste o salário médio pago pela empresa. */ 
SELECT AVG(salario)::MONEY
	FROM funcionario;
	
/* 13 - Liste o menor salário pago pela empresa em 
cada departamento. */
SELECT d.nome AS departamento, MIN(f.salario)::MONEY AS salario
	FROM departamento d INNER JOIN funcionario f
		ON d.codigo = f.codigodepartamento
	GROUP BY d.nome;
	
SELECT d.nome AS departamento, MIN(f.salario)::MONEY AS salario
	FROM departamento d, funcionario f
	WHERE d.codigo = f.codigodepartamento
	GROUP BY d.nome;
	
/* 14 - Liste o nome completo de todos os funcionários 
que nasceram antes de 01/01/1980. */
SELECT CONCAT(nome, ' ', sobrenome) AS funcionario, datanasci
	FROM funcionario
	WHERE datanasci < '01/01/1980'
	ORDER BY datanasci DESC;
	
/* 15 - Liste o nome do departamento e do funcionário 
ordenados por departamento e funcionário. */
SELECT f.nome AS funcionario, d.nome AS departamento
	FROM funcionario f INNER JOIN departamento d
		ON f.codigodepartamento = d.codigo
	ORDER BY d.nome, f.nome;
	
SELECT f.nome AS funcionario, d.nome AS departamento
	FROM funcionario f, departamento d
	WHERE f.codigodepartamento = d.codigo
	ORDER BY d.nome, f.nome;
	
/* 16 - Liste os nomes dos funcionários que moram em 
Cidade Z e que exerçam a função de Telefonista. */
SELECT *
	FROM funcionario
	WHERE cidade = 'Cidade Z'
		AND funcao = 'Telefonista';
		
/* 17 - Liste os nomes dos funcionários que trabalham no 
Departamento Pessoal. */
SELECT f.nome AS funcionario, d.nome AS departamento
	FROM funcionario f INNER JOIN departamento d
		ON f.codigodepartamento = d.codigo
	WHERE d.nome = 'Departamento Pessoal';
	
SELECT f.nome AS funcionario, d.nome AS departamento
	FROM funcionario f, departamento d
	WHERE f.codigodepartamento = d.codigo
		AND d.nome = 'Departamento Pessoal';
		
/* 18 - Liste o nome e o departamento de todos os funcionários 
que ganham mais do que algum gerente. */
SELECT f.nome AS funcionario, d.nome AS departamento, f.salario::MONEY AS salario
	FROM funcionario f INNER JOIN departamento d
		ON f.codigodepartamento = d.codigo
	WHERE f.salario > ( SELECT salario
					   	FROM funcionario
					   	WHERE codigo = d.cod_func_gerente );

SELECT f.nome AS funcionario, d.nome AS departamento, f.salario::MONEY AS salario
	FROM funcionario f, departamento d
	WHERE f.codigodepartamento = d.codigo
		AND f.salario > ( SELECT salario
					   	  FROM funcionario
					   	  WHERE codigo = d.cod_func_gerente );

SELECT f.nome AS funcionario, d.nome AS departamento, f.salario::MONEY AS salario
	FROM funcionario f INNER JOIN departamento d
		ON f.codigodepartamento = d.codigo
	WHERE f.salario > ( SELECT MIN(salario)
					   	FROM funcionario
					   	WHERE codigo = d.cod_func_gerente );