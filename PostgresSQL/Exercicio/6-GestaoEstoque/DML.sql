/* Insert fornecedor */
INSERT INTO fornecedor
	(razao_social, cnpj)
	VALUES
	('Eletronic Arts', '123456'),
	('Montreal Studio', '456789');

/* Insert cliente */
INSERT INTO cliente
	(nome, cpf)
	VALUES
	('Saitama', '789456'),
	('Genos', '537159');

/* Insert Compra */
SELECT * FROM produto;
SELECT * FROM compra;
SELECT * FROM item_compra;

INSERT INTO produto
	(descricao, quantidade, valor_unit, estoque_min)
	VALUES
	('Lápis', 0, 1.90, 10);

INSERT INTO compra
	(codigo_f)
	VALUES
	(1);
	
INSERT INTO item_compra
	(codigo_comp, codigo_p, quantidade, valor_unit)
	VALUES
	(1, 1, 50, 0.90);

/* Delete compra */
INSERT INTO produto
	(descricao, quantidade, valor_unit, estoque_min)
	VALUES
	('Borracha', 0, 0.90, 10);
	
INSERT INTO item_compra
	(codigo_comp, codigo_p, quantidade, valor_unit)
	VALUES
	(1, 2, 50, 0.10);
	
DELETE FROM item_compra
	WHERE codigo_comp = 1
		AND codigo_p = 2;

/* Insert venda */
SELECT * FROM produto;
SELECT * FROM venda;
SELECT * FROM item_venda;
SELECT * FROM cliente;
SELECT * FROM pagamento;

INSERT INTO venda
	(codigo_c)
	VALUES
	(1);
	
INSERT INTO item_venda
	(codigo_v, codigo_p, quantidade)
	VALUES
	(1, 1, 2);

INSERT INTO item_venda
	(codigo_v, codigo_p, quantidade)
	VALUES
	(1, 2, 2);

/* Update parcela */
UPDATE venda
	SET parcela = 2
	WHERE codigo_v = 1;

/* Delete venda */
DELETE FROM item_venda
	WHERE codigo_v = 1;

/* Update produto */
SELECT * FROM produto;
SELECT * FROM historico_valor_produto;

UPDATE produto
	SET valor_unit = 1.50
	WHERE codigo_p = 1;