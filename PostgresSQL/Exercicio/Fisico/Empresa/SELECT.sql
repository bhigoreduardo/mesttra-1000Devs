/* Listar nome e Sobrenome de Funcionários ordenado por sobrenome. */
SELECT nome, sobrenome
FROM funcionario
ORDER BY sobrenome ASC;

/* Listar todos os campos de Funcionários ordenados por cidade. */
SELECT *
FROM funcionario
ORDER BY cidade ASC;

/* Liste os funcionários que têm salário superior a R$ 1.000,00 ordenados pelo nome completo. */
SELECT *
FROM funcionario
WHERE salario > 1000
ORDER BY nome, sobrenome ASC;

/* Liste a data de nascimento e o primeiro nome dos funcionários ordenados do mais novo para o mais velho. */

/* Liste os funcionários como uma lista telefônica (Nome, SobreNome, Fone, Endereço, Cidade, UF). */
SELECT nome, sobrenome, fone, endereco, cidade, uf
FROM funcionario;

/* Liste o total da folha de pagamento. */
SELECT SUM(salario) AS folha_pagamento
FROM funcionario;

/* Liste o nome, Sobrenome, Nome do Departamento e a função de todos os funcionários. */
SELECT f.nome, f.sobrenome, f.funcao, d.nome
FROM funcionario f
INNER JOIN departamento d
ON f.codigo_departamento = d.codigo;

/* Liste todos os departamentos com seus respectivos gerentes. */
SELECT d.*, f.nome
FROM departamento d
INNER JOIN funcionario f
ON d.codigo_funcionario = f.codigo;

/* Liste o valor da folha de pagamento de cada departamento, ordenado pelo nome do departamento. */
SELECT d.nome, SUM(f.salario) AS folha_pagamento
FROM departamento d
INNER JOIN funcionario f
ON d.codigo = f.codigo_departamento
GROUP BY d.nome;

/* Liste os departamentos dos funcionários que têm a função de Supervisor. */
SELECT d.nome
FROM departamento d
LEFT JOIN funcionario f
ON d.codigo = f.codigo_departamento
WHERE f.funcao = 'CEO';

/*  Liste a quantidade de funcionários desta empresa. */
SELECT COUNT(*) AS funcionarios
FROM funcionario;

/* Liste o salário médio pago pela empresa. */
SELECT AVG(salario) AS salario_medio
FROM funcionario;

/* Liste o menor salário pago pela empresa em cada departamento. */
SELECT d.nome, MIN(salario) AS salario_minino
FROM departamento d
LEFT JOIN funcionario f
ON d.codigo = f.codigo_departamento
GROUP BY d.nome;

/* Liste o nome completo de todos os funcionários que nasceram antes de 01/01/1980. */


/* Liste o nome do departamento e do funcionário ordenados por departamento e funcionário. */
SELECT d.nome AS departamento, f.nome AS funcionario
FROM funcionario f
LEFT JOIN departamento d
ON f.codigo_departamento = d.codigo
ORDER BY d.nome, f.nome;

/* Liste os nomes dos funcionários que moram em Itumbiara e que exerçam a função de telefonista. */
SELECT nome
FROM funcionario
WHERE cidade = 'Itumbiara' AND funcao = 'Telefonista';

/* Liste os nomes dos funcionários que trabalham no Departamento Pessoal. */

/* Liste o nome e o departamento de todos os funcionários que ganham mais do que algum gerente. */