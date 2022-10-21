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