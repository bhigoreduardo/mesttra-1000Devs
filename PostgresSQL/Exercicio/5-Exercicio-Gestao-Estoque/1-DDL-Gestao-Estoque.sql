/* Created Database */
CREATE DATABASE gestao_estoque
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

/* Created Table produto */
CREATE TABLE IF NOT EXISTS produto (
	codigo_p SERIAL PRIMARY KEY,
	descricao VARCHAR(100) NOT NULL,
	quantidade NUMERIC(15,3) NOT NULL,
	valor_unit NUMERIC(9,2) NOT NULL,
	estoque_min NUMERIC(15,3) NOT NULL,
	CHECK (quantidade >= 0),
	CHECK (valor_unit >= 0)
);

/* Created Table cliente */
CREATE TABLE IF NOT EXISTS cliente (
	codigo_c SERIAL PRIMARY KEY,
	nome VARCHAR(150) NOT NULL,
	endereco VARCHAR(200),
	cpf VARCHAR(14) NOT NULL UNIQUE
);

/* Created Table fornecedor */
CREATE TABLE IF NOT EXISTS fornecedor (
	codigo_f SERIAL PRIMARY KEY,
	razao_social VARCHAR(150) NOT NULL,
	endereco VARCHAR(200),
	cnpj VARCHAR(18) NOT NULL UNIQUE
);

/* Created Table compra */
CREATE TABLE IF NOT EXISTS compra (
	codigo_comp SERIAL PRIMARY KEY,
	data_c DATE NOT NULL DEFAULT(CURRENT_DATE),
	codigo_f INTEGER NOT NULL REFERENCES fornecedor,
	valor_total NUMERIC(9,2) NOT NULL DEFAULT 0,
	CHECK (valor_total >= 0)
);

/* Created Table item_compra */
CREATE TABLE IF NOT EXISTS item_compra (
	codigo_comp INTEGER NOT NULL REFERENCES compra,
	codigo_p INTEGER NOT NULL REFERENCES produto,
	quantidade NUMERIC(15,3) NOT NULL,
	valor_unit NUMERIC(9,2) NOT NULL,
	PRIMARY KEY (codigo_comp, codigo_p),
	CHECK (quantidade > 0),
	CHECK (valor_unit >= 0)
);

/* Created Table venda */
CREATE TABLE IF NOT EXISTS venda (
	codigo_v SERIAL PRIMARY KEY,
	data_v DATE NOT NULL DEFAULT(CURRENT_DATE),
	codigo_c INTEGER NOT NULL REFERENCES cliente,
	valor_total NUMERIC(9,2) NOT NULL DEFAULT 0,
	parcela INTEGER NOT NULL DEFAULT 0,
	CHECK (parcela >= 0)
);

/* Created Table item_venda */
CREATE TABLE IF NOT EXISTS item_venda (
	codigo_v INTEGER NOT NULL REFERENCES venda,
	codigo_p INTEGER NOT NULL REFERENCES produto,
	quantidade NUMERIC(15,3) NOT NULL,
	valor_unit NUMERIC(9,2) NOT NULL,
	CHECK (quantidade > 0),
	CHECK (valor_unit >= 0)
);

/* Created Table historico_valor_produto */
CREATE TABLE IF NOT EXISTS historico_valor_produto (
	codigo_h SERIAL PRIMARY KEY,
	codigo_p INTEGER NOT NULL REFERENCES produto,
	valor_unit NUMERIC(9,2) NOT NULL,
	data_alteracao DATE NOT NULL DEFAULT(CURRENT_DATE)
);

/* Created Table pagamento */
CREATE TABLE IF NOT EXISTS pagamento (
	codigo_v INTEGER NOT NULL REFERENCES venda,
	nro_parcela INTEGER NOT NULL,
	data_venc DATE NOT NULL,
	data_pagto DATE,
	valor_parc NUMERIC(9,2) NOT NULL,
	valor_pago NUMERIC(9,2),
	PRIMARY KEY (codigo_v, nro_parcela),
	CHECK (valor_parc >= 0)
);

/*
Produtos ao atingirem Quantidade inferior ao EstoqueMinimo devem apresentar
uma mensagem informando o estoque mínimo;
*/
/*
A cada alteração no Valor_Unit de Produto, deve ser armazenado no Historico_Valor_Produto;
*/
CREATE OR REPLACE FUNCTION fc_verificar_estoque_minimo() RETURNS TRIGGER AS
$$
BEGIN
	-- Mensagem informando o estoque mínimo
	IF ( ( SELECT (quantidade)
		   FROM produto
		   WHERE codigo_p = NEW.codigo_p ) <= ( SELECT estoque_min
											  	FROM produto
											  	WHERE codigo_p = NEW.codigo_p ) ) THEN
		RAISE NOTICE 'Quantidade estoque inferior a estoque mínimo.';
	END IF;
	
	-- Alteração no Valor_Unit de Produto
	IF ( NEW.valor_unit != OLD.valor_unit ) THEN
		INSERT INTO historico_valor_produto
			(codigo_p, valor_unit)
			VALUES
			(NEW.codigo_p, OLD.valor_unit);
			
		RAISE NOTICE 'Valor do produto alterado e registrado.';
	END IF;
	
	RETURN NULL;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_verificar_estoque_minimo
AFTER UPDATE ON produto
FOR EACH ROW EXECUTE PROCEDURE fc_verificar_estoque_minimo();

/*
Compras devem acrescentar a Quantidade de Produtos ao estoque;
*/
/*
Valor_Total de Compra deve ser gerado automaticamente ao lançar Itens_Compra;
*/
CREATE OR REPLACE FUNCTION fc_comprar_produto() RETURNS TRIGGER AS
$$
BEGIN
	-- Acrescentar a Quantidade de Produtos
	UPDATE produto
		SET quantidade = quantidade + NEW.quantidade
		WHERE codigo_p = NEW.codigo_p;
	
	-- Valor_Total de Compra deve ser gerado automaticamente
	UPDATE compra
		SET valor_total = valor_total + (NEW.quantidade * NEW.valor_unit)
		WHERE codigo_comp = NEW.codigo_comp;
		
	RAISE INFO 'Produto adicionado ao estoque e fatura da compra atualizada.';
	
	RETURN NULL;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_comprar_produto
AFTER INSERT ON item_compra
FOR EACH ROW EXECUTE PROCEDURE fc_comprar_produto();

/*
Valor_Total de Venda deve ser gerado automaticamente ao lançar Itens_Venda;
*/
/*
Itens_Venda deve reduzir Quantidade de Produto, caso a quantidade em estoque
não seja suficiente, não deve aceitar o lançamento, informando não existir
produtos suficientes em estoque;
*/
/*
Itens_Venda deve buscar Valor_Unit de Produto;
*/
CREATE OR REPLACE FUNCTION fc_vender_produto() RETURNS TRIGGER AS
$$
BEGIN
	-- Quantidade em estoque não seja suficiente
	IF ( NEW.quantidade > ( SELECT quantidade
						  	FROM produto
						  	WHERE codigo_p = NEW.codigo_p ) ) THEN
		RAISE EXCEPTION 'Quantidade solicitada não possui em estoque.';
	ELSE
		-- Itens_Venda deve buscar Valor_Unit de Produto;
		NEW.valor_unit = ( SELECT valor_unit
						   FROM produto
						   WHERE codigo_p = NEW.codigo_p );
						 
		-- Reduzir Quantidade de Produto
		UPDATE produto
			SET quantidade = quantidade - NEW.quantidade
			WHERE codigo_p = NEW.codigo_p;
		
		-- Valor_Total de Venda deve ser gerado automaticamente
		UPDATE venda
			SET valor_total = valor_total + (NEW.quantidade * NEW.valor_unit)
			WHERE codigo_v = NEW.codigo_v;
			
		RAISE INFO 'Quantidade em estoque reduzida e fatura da venda atualizada.';
		
		RETURN NEW;
	END IF;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_vender_produto
BEFORE INSERT ON item_venda
FOR EACH ROW EXECUTE PROCEDURE fc_vender_produto();

/*
Parcelas em Venda deve gerar automaticamente lançamentos em Pagamento de acordo com a
quantidade de parcelas solicitadas;
*/
CREATE OR REPLACE FUNCTION fc_gerar_parcela() RETURNS TRIGGER AS
$$
DECLARE
	num_parcela INTEGER;
	data_vecto DATE;
	valor_parcela NUMERIC(9,2);
BEGIN
	num_parcela = 1;
	data_vecto = NEW.data_v;
	
	IF (NEW.parcela > 0) THEN
		DELETE FROM pagamento
			WHERE codigo_v = NEW.codigo_v;
		
		valor_parcela = NEW.valor_total / NEW.parcela;
			
		WHILE (NEW.parcela >= num_parcela) LOOP
			data_vecto = data_vecto + INTERVAL'1 month';
			
			INSERT INTO pagamento
				(codigo_v, nro_parcela, data_venc, valor_parc)
				VALUES
				(NEW.codigo_v, num_parcela, data_vecto, valor_parcela);
				
			num_parcela = num_parcela + 1;
		END LOOP;
		
		RAISE INFO 'Parcelas geradas.';
	END IF;
	
	RETURN NULL;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_gerar_parcela
AFTER UPDATE ON venda
FOR EACH ROW EXECUTE PROCEDURE fc_gerar_parcela();

/*
Ao excluir Itens_Venda ou Itens_Compra, os valores de Venda e Compra devem ser atualizados;
*/
-- Excluir item_compra
CREATE OR REPLACE FUNCTION fc_excluir_item_compra() RETURNS TRIGGER AS
$$
BEGIN	
	IF ( ( SELECT quantidade
		   FROM produto
		   WHERE codigo_p = OLD.codigo_p) < OLD.quantidade ) THEN
		   RAISE EXCEPTION 'Quantidade em estoque insuficiente para estorno.';
		   
	ELSE
		UPDATE compra
			SET valor_total = valor_total - (OLD.quantidade * OLD.valor_unit)
			WHERE codigo_comp = OLD.codigo_comp;
		
		UPDATE produto
			SET quantidade = quantidade - (OLD.quantidade)
			WHERE codigo_p = OLD.codigo_p;
			
		RAISE INFO 'Quantidade estoque e fatura de compra atualizados.';
		
		RETURN OLD;
	END IF;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_exceluit_item_compra
BEFORE DELETE ON item_compra
FOR EACH ROW EXECUTE PROCEDURE fc_excluir_item_compra();

-- Excluir item_venda
CREATE OR REPLACE FUNCTION fc_excluir_item_venda() RETURNS TRIGGER AS
$$
BEGIN
	UPDATE venda
		SET valor_total = valor_total - (OLD.quantidade * OLD.valor_unit)
		WHERE codigo_v = OLD.codigo_v;
		
	UPDATE produto
		SET quantidade = quantidade + OLD.quantidade
		WHERE codigo_p = OLD.codigo_p;
		
	RAISE INFO 'Estoque e fatura de venda atualizados.';
	
	RETURN OLD;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_excluir_item_venda
AFTER DELETE ON item_venda
FOR EACH ROW EXECUTE PROCEDURE fc_excluir_item_venda();