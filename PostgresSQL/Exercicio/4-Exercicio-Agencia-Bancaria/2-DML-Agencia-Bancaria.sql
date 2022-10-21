/* Insert funcionario */
INSERT INTO funcionario
	(nome)
	VALUES
	('Blast'),
	('Borus');

/* Insert agencia */
INSERT INTO agencia
	(nome, endereco, telefone, gerente)
	VALUES
	('Hero Association', 'Cidade A', '00111111111', 1),
	('Monster Association', 'Cidade Z', '00999999999', 2);

/* Insert cliente */
INSERT INTO cliente
	(nome, sobrenome, endereco, genero)
	VALUES
	('Saitama', 'Sensei', 'Cidade Z', 'M'),
	('Genos', 'Cyborg', 'Cidade Z', 'M'),
	('Child', 'Empreror', 'Cidade A', 'M'),
	('King', 'Motor', 'Cidade A', 'M');

/* Insert conta */
INSERT INTO conta
	(cod_agencia, cod_cliente, saldo)
	VALUES
	(2, 1, 10000),
	(2, 2, 20000),
	(2, 3, 40000),
	(2, 4, 50000);

/* Insert saque */
INSERT INTO saque
	(cod_conta, valor_saque)
	VALUES
	(9, 100001);

INSERT INTO saque
	(cod_conta, valor_saque)
	VALUES
	(9, 10001);