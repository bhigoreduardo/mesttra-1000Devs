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

