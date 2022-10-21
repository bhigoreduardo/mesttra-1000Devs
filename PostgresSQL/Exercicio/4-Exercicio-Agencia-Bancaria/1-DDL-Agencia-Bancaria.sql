/* Created Database */
CREATE DATABASE agencia_bancaria
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

/* Created Table agencia */
CREATE TABLE IF NOT EXISTS agencia (
	cod_agencia SERIAL PRIMARY KEY,
	nome VARCHAR(140) NOT NULL,
	endereco VARCHAR(140) NOT NULL,
	telefone VARCHAR(20) NOT NULL,
	gerente INTEGER NOT NULL
);

/* Created Table funcionario */
CREATE TABLE IF NOT EXISTS funcionario (
	cod_funcionario SERIAL PRIMARY KEY,
	nome VARCHAR(140) NOT NULL,
	cod_agencia INTEGER REFERENCES agencia
);

/* Added Constraint gerente in Table agencia */
ALTER TABLE agencia
	ADD CONSTRAINT fk_agencia_gerente
	FOREIGN KEY (gerente) REFERENCES funcionario;

/* Created Table cliente */
CREATE TABLE IF NOT EXISTS cliente (
	cod_cliente SERIAL PRIMARY KEY,
	nome VARCHAR(40) NOT NULL,
	sobrenome VARCHAR(60) NOT NULL,
	endereco VARCHAR(100),
	genero CHAR(1) NOT NULL
);

/* Created Table conta */
CREATE TABLE IF NOT EXISTS conta (
	cod_conta SERIAL PRIMARY KEY,
	cod_agencia INTEGER REFERENCES agencia,
	cod_cliente INTEGER REFERENCES cliente,
	saldo NUMERIC(9,2) NOT NULL,
	limite NUMERIC(9,2) NOT NULL
);

/*
Regra de Negócio:
    Quando for cadastrar uma nova conta o limite inicial sempre deverá ser de R$ 100,00. */
/* Set Default Value in Table conta Column limite */
ALTER TABLE conta
	ALTER COLUMN limite SET DEFAULT(100.00);

/* Created Table saque */
CREATE TABLE IF NOT EXISTS saque (
	cod_saque SERIAL PRIMARY KEY,
	data_saque DATE NOT NULL DEFAULT(CURRENT_DATE),
	cod_conta INTEGER REFERENCES conta,
	valor_saque NUMERIC(9,2) NOT NULL,
	CHECK (valor_saque > 0)
);

/* Created Table deposito */
CREATE TABLE IF NOT EXISTS deposito (
	cod_deposito SERIAL PRIMARY KEY,
	data_deposito DATE NOT NULL DEFAULT(CURRENT_DATE),
	cod_conta INTEGER REFERENCES conta,
	valor_deposito NUMERIC(9,2) NOT NULL,
	CHECK (valor_deposito > 0)
);

/* Created Table transferencia */
CREATE TABLE IF NOT EXISTS transferencia (
	cod_transferencia SERIAL PRIMARY KEY,
	data_transferencia DATE NOT NULL DEFAULT(CURRENT_DATE),
	cod_conta_deb INTEGER REFERENCES conta,
	cod_conta_cred INTEGER REFERENCES conta,
	valor_transferencia NUMERIC(9,2) NOT NULL,
	CHECK (valor_transferencia > 0)
);

/*
Regra de Negócio:
    Quando for cadastrar uma nova conta o limite inicial sempre deverá ser de R$ 100,00. */
/* Created Function-Trigger registrar_conta */
CREATE OR REPLACE FUNCTION fc_registrar_conta() RETURNS TRIGGER AS
$$
BEGIN
	NEW.limite = 100.00;
	RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_registrar_conta
BEFORE INSERT ON conta
FOR EACH ROW EXECUTE PROCEDURE fc_registrar_conta();

/* Regra de Negócio:
    Quando um cliente for efetuar um saque o sistema deve verificar se existe saldo suficiente para realizar o saque. */
/* Created Function-Trigger efetuar_saque */
CREATE OR REPLACE FUNCTION fc_efetuar_saque() RETURNS TRIGGER AS
$$
BEGIN
	/* Verificar saldo */
	/* CASE 1:
		saldo: R$ 20,00 AND limite: R$ 10,00 => saque máx: R$ 30,00
	   CASE 2:
	   	saldo: R$ -5,00 AND limite: R$ 10,00 => saque máx: R$ 5,00
	   CASE 3:
	   	saldo: R$ -10,00 AND limite: R$ 10,00 => saque máx: R$ 0,00
	   RESULT:
	   	O valor do saque deve ser menor que a soma entre saldo e limite.
	*/
	IF ( NEW.valor_saque > (SELECT (saldo + limite)
	   	                    FROM conta
	   	                    WHERE cod_conta = NEW.cod_conta) ) THEN
		 RAISE EXCEPTION 'O saldo e limite em conta são insuficientes para realizar o saque.';
	ELSE
		/* Debitar saldo */
		UPDATE conta
			SET saldo = saldo - NEW.valor_saque
			WHERE cod_conta = NEW.cod_conta;
		RAISE NOTICE 'Saque realizado no valor de R$ %', NEW.valor_saque;
		/* Lançar saque */
		RETURN NEW;
	END IF;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_efetuar_saque
BEFORE INSERT ON saque
FOR EACH ROW EXECUTE PROCEDURE fc_efetuar_saque();

/* Regra de Negócio:
    Quando for feito um depósito o valor depositado deve ser acrescentado ao saldo da conta do cliente. */
/* Created Function-Trigger efetuar_deposito  */
CREATE OR REPLACE FUNCTION fc_efetuar_deposito() RETURNS TRIGGER AS
$$
BEGIN
	UPDATE conta
		SET saldo = saldo + NEW.valor_deposito
		WHERE cod_conta = NEW.cod_conta;
	RAISE INFO 'Depósito efetuado com sucesso.';
	RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_efetuar_deposito
BEFORE INSERT ON deposito
FOR EACH ROW EXECUTE PROCEDURE fc_efetuar_deposito();

/* Regra de Negócio:
    Quando for feita uma transferência é necessário verificar se existe saldo na conta que receberá o débito e,
    caso exista o saldo, efetuar o crédito na conta destinatária. */
/* Created Function-Trigger efetuar_transferencia  */
CREATE OR REPLACE FUNCTION fc_efetuar_transferencia() RETURNS TRIGGER AS
$$
BEGIN
	/* Verificar saldo */
	IF ( NEW.valor_transferencia > ( SELECT (saldo + limite)
								     FROM conta
								   	 WHERE cod_conta = cod_conta_deb) ) THEN
		RAISE EXCEPTION 'O saldo e limite em conta são insuficientes para realizar a transferência.';
	ELSE
		/* Debitar saldo */
		UPDATE conta
			SET saldo = saldo - NEW.valor_transferencia
			WHERE cod_conta = NEW.cod_conta_deb;
		/* Creditar saldo */
		UPDATE conta
			SET saldo = saldo + NEW.valor_transferencia
			WHERE cod_conta = NEW.cod_conta_cred;
		RAISE NOTICE 'Transferência efetuada no valor de R$ %', NEW.valor_transferencia;
		RETURN NEW;
	END IF;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_efetuar_transferencia
BEFORE INSERT ON transferencia
FOR EACH ROW EXECUTE PROCEDURE fc_efetuar_transferencia();


/* Regra de Negócio:
   Quando o limite da conta for alterado, o sistema deve verificar se o novo limite não é inferior ao saldo atual. */
/* Created Function-Trigger alterar_limite  */
CREATE OR REPLACE FUNCTION fc_alterar_limite() RETURNS TRIGGER AS
$$
BEGIN
	/* Verificar saldo */
	/* CASE 1:
		saldo: R$ 20,00 AND limite: R$ 10,00 => saque máx: R$ 30,00
	   CASE 2:
	   	saldo: R$ -5,00 AND limite: R$ 10,00 => saque máx: R$ 5,00
	   CASE 3:
	   	saldo: R$ -10,00 AND limite: R$ 10,00 => saque máx: R$ 0,00
	   RESULT:
	   	A soma entre saldo e limite deve ser igual ou maior que ZERO.
	*/
	IF ( NEW.limite + OLD.saldo < 0 ) THEN
		RAISE EXCEPTION 'O novo limite não pode ser alterado.';
	END IF;
	
	RAISE NOTICE 'Limite alterado com sucesso.';
	RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER tr_alterar_limite
BEFORE UPDATE ON conta
FOR EACH ROW EXECUTE PROCEDURE fc_alterar_limite();